package com.example.QuanAoBla.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "PasswordHash")
    private String passwordHash;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private Roles roles;

    @Column(name = "Active")
    private Integer active;

    @Column(name = "CreatedAt")
    private LocalDate createdAt;
}
