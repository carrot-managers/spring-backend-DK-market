package com.opensource.backdk.service;

import com.opensource.backdk.domain.User;
import com.opensource.backdk.dto.SigninUserDto;
import com.opensource.backdk.dto.SignupUserDto;
import com.opensource.backdk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User signup(SignupUserDto dto) {
        User user = new User(dto);
        return userRepository.save(user);
    }

    public User signin(SigninUserDto dto, HttpServletRequest request) {
        User user = userRepository.findById(dto.getId()).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new NullPointerException("비밀번호가 일치하지 않습니다.");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return user;
    }
}
