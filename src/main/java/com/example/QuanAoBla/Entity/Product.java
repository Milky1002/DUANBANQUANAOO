package com.example.QuanAoBla.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Products")  // Đảm bảo tên bảng là "Products"
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để tự động sinh giá trị ID
    @Column(name = "ProductID") // Tên cột trong cơ sở dữ liệu
    private Long id;

    @Column(name = "ProductName", nullable = false, length = 100)  // Tên sản phẩm, không null
    private String name;

    @Column(name = "Description", length = 255)  // Mô tả sản phẩm
    private String description;

    @Column(name = "Price", nullable = false)  // Giá sản phẩm, không null
    private double price;

    @Column(name = "CategoryID")  // ID của danh mục sản phẩm
    private Long categoryId;

    @Column(name = "QuantityInStock")  // Số lượng trong kho
    private int quantityInStock;

    @Column(name = "CreatedAt", nullable = false)  // Ngày tạo sản phẩm, không null
    private java.time.LocalDateTime createdAt;
}
