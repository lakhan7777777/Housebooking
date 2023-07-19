package com.houseproject.payload;



import lombok.Data;

@Data
public class LoginDto {
    private  String usernameOrEmail;
    private String password;
}
//data comes to this object from postman
