package com.opensource.backdk.controller;

import com.opensource.backdk.domain.User;
import com.opensource.backdk.dto.SigninUserDto;
import com.opensource.backdk.dto.SignupUserDto;
import com.opensource.backdk.repository.UserRepository;
import com.opensource.backdk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/user/signup")
    public User signUp(@RequestBody SignupUserDto dto) {
        return userService.signup(dto);
    }

    @PostMapping("/user/signin")
    public User signIn(@RequestBody SigninUserDto dto, HttpServletRequest request) {
        return userService.signin(dto, request);
    }

}
