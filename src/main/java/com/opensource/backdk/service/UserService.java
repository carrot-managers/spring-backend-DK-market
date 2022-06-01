package com.opensource.backdk.service;

import com.opensource.backdk.domain.User;
import com.opensource.backdk.dto.SignupUserDto;
import com.opensource.backdk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User signup(SignupUserDto dto) {
        User user = new User(dto);
        return userRepository.save(user);
    }

}
