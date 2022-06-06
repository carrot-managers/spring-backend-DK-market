package com.opensource.backdk.controller;

import com.opensource.backdk.domain.Users;
import com.opensource.backdk.dto.SigninUserDto;
import com.opensource.backdk.dto.SignupUserDto;
import com.opensource.backdk.repository.UserRepository;
import com.opensource.backdk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public Users signUp(@RequestBody SignupUserDto dto) {
        return userService.signup(dto);
    }

    @PostMapping("/user/signin")
    public Users signIn(@RequestBody SigninUserDto dto, HttpServletRequest request) {
        return userService.signin(dto, request);
    }

    @PostMapping("/user/logout")
    public String logout(@ModelAttribute("user") Users user, HttpServletRequest request) {
        return userService.logout(user, request);
    }

    @GetMapping("/user/current")
    public Users getCurrentUser(HttpServletRequest request) {
        return userService.getCurrentUser(request);
    }

}
