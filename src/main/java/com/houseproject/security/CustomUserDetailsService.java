package com.houseproject.security;



import com.houseproject.entities.Role;
import com.houseproject.entities.User;
import com.houseproject.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //inbuilt metod
    //all username and password we are entering in login it comes here and tjis is done by SB
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));//builtin exception
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));//here the complete object we are returning back
    }               //we are supplying this details to builtin User class of spring security

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

//The returned UserDetails object is then used by Spring Security to perform authentication and authorization for the user during the login process
//These GrantedAuthority objects are then used by Spring Security to perform authorization checks for the user during the login process. For example, if a user has the authority "ROLE_ADMIN", they might be granted access to certain parts of the application that are not available to "ROLE_USER" users.