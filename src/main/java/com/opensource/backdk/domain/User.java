package com.opensource.backdk.domain;

import com.opensource.backdk.dto.SignupUserDto;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    public User(SignupUserDto dto) {
        this.id = dto.getId();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.phone = dto.getPhone();
    }
}
