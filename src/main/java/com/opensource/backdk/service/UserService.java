package com.opensource.backdk.service;

import com.opensource.backdk.domain.Users;
import com.opensource.backdk.dto.SigninUserDto;
import com.opensource.backdk.dto.SignupUserDto;
import com.opensource.backdk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Users signup(SignupUserDto dto) {
        Users user = new Users(dto);
        return userRepository.save(user);
    }

    @Transactional
    public Users signin(SigninUserDto dto, HttpServletRequest request) {
        Users user = userRepository.findByUserId(dto.getUserId()).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new NullPointerException("비밀번호가 일치하지 않습니다.");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return user;
    }

    @Transactional
    public String logout(Users user, HttpServletRequest request) {
        HttpSession session =request.getSession();
        session.invalidate();
        return user.getUserId();
    }

    public Users getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Users) session.getAttribute("user");
    }
}
