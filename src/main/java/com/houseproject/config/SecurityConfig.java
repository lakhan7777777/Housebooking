package com.houseproject.config;




import com.houseproject.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}

//this is used to put the useranme password into  the temporaary memory for testing purpose
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails ramesh = User.builder().username("ramesh").password(passwordEncoder()
//                .encode("password")).roles("USER").build();
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder()
//                .encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(ramesh, admin);
//    }

//The userDetailsService property is an instance of CustomUserDetailsService which is passed into the constructor of SecurityConfig. This instance is then used to configure the AuthenticationManagerBuilder by calling the userDetailsService() method on the auth object.
//
//By doing this, the AuthenticationManagerBuilder is configured to use CustomUserDetailsService to load user details from the database.
// When a user attempts to authenticate, the AuthenticationManager will delegate the authentication process to the configured UserDetailsService. The UserDetailsService will then
// retrieve the user details from the database and return them to the AuthenticationManager. The AuthenticationManager will then check if the password entered by the user matches the hashed
// password stored in the database. If the passwords match, the user is authenticated and granted access to the application.




//SecurityConfig: This is where the overall Spring Security
// configuration is defined. In this class, we define the UserDetailsService to be used for authentication, configure the password
// encoder, and define any security rules. The CustomUserDetailsService is injected as a dependency here.
//
//CustomUserDetailsService: This class implements the UserDetailsService interface and provides an implementation
// for the loadUserByUsername method, which is called by Spring Security during authentication. This method retrieves a User object from the database using the UserRepository,
// and returns a UserDetails object that Spring Security can use for authentication.
//
//AuthController: This is the controller responsible for handling user authentication. When a user
// attempts to sign in, the authenticateUser method is called. This method uses the AuthenticationManager
// to authenticate the user's credentials. The AuthenticationManager uses the CustomUserDetailsService to load the user's details and compare the provided credentials with those in the database.
// If the authentication is successful, the SecurityContextHolder is updated with the authenticated Authentication object.
//
//So, the flow goes like this:
//
//AuthController -> AuthenticationManager -> CustomUserDetailsService -> UserRepository
//
//The AuthController calls the authenticate method of the AuthenticationManager with the user's credentials,
// which in turn calls the loadUserByUsername method of the CustomUserDetailsService to retrieve the user's
// details from the database. Once the authentication is successful, the SecurityContextHolder is updated with the authenticated Authentication object, which can be used to determine whether the user is authorized to perform certain actions in the application.
