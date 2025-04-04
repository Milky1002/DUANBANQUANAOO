package com.example.QuanAoBla.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users user;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "position")
    private String position;

    @Column(name = "hireDate")
    private LocalDate hireDate;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "isActive")
    private Boolean isActive;
}