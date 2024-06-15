package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(max = 50)
    private String username;

    @NotNull
    @Length(max = 100)
    private String password;

    @NotNull
    @Length(max = 100)
    private String fullname;

    @NotNull
    @Length(max = 100)
    private String email;

    @NotNull
    @Length(max = 20)
    private String role;
}
