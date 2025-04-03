package com.example.QuanAoBla.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate; // Thêm LocalDate để xử lý ngày tháng

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customers")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer id;

    @Column(name = "FullName")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "CreatedAt")
    private LocalDate createdAt;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now(); // Tự động gán ngày hiện tại cho CreatedAt
    }
}
