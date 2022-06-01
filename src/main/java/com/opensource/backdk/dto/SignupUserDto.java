package com.opensource.backdk.dto;

import lombok.Getter;

@Getter
public class SignupUserDto {
    private Long id;
    private String password;
    private String email;
    private String name;
    private String phone;
}
