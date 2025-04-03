package com.example.QuanAoBla.Repository;

import com.example.QuanAoBla.Entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    Page<KhachHang> findAll(Pageable pageable);
    Page<KhachHang> findByNameContaining(String name, Pageable pageable);

    // Tìm kiếm theo tên khách hàng và lọc theo giới tính
    Page<KhachHang> findByNameContainingAndGender(String name, String gender, Pageable pageable);

    // Lọc theo giới tính
    Page<KhachHang> findByGender(String gender, Pageable pageable);

}
