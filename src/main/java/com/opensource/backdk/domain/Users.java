package com.opensource.backdk.domain;

import com.opensource.backdk.dto.SignupUserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    public Users(SignupUserDto dto) {
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.phone = dto.getPhone();
    }
}
