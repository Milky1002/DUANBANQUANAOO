package com.example.QuanAoBla.Service;

import com.example.QuanAoBla.Entity.KhachHang;
import com.example.QuanAoBla.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    // Phương thức phân trang
    public Page<KhachHang> getPaginatedCustomers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  // Tạo đối tượng Pageable với trang và kích thước
        return khachHangRepository.findAll(pageable);    // Gọi phương thức phân trang từ Repository
    }
    public void addCustomer(KhachHang khachHang) {
        khachHangRepository.save(khachHang); // Lưu khách hàng vào cơ sở dữ liệu
    }
    public KhachHang getCustomerById(Integer id) {
        return khachHangRepository.findById(id).orElse(null); // Lấy khách hàng theo ID
    }

    public void updateCustomer(KhachHang khachHang) {
        khachHangRepository.save(khachHang); // Cập nhật khách hàng
    }
    public void deleteCustomer(Integer id) {
        khachHangRepository.deleteById(id); // Xóa khách hàng theo ID
    }
    public Page<KhachHang> getFilteredCustomers(String search, String genderFilter, int page) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang hiển thị 10 khách hàng

        if (search != null && !search.isEmpty() && genderFilter != null && !genderFilter.isEmpty()) {
            // Tìm kiếm theo tên và lọc theo giới tính
            return khachHangRepository.findByNameContainingAndGender(search, genderFilter, pageable);
        } else if (search != null && !search.isEmpty()) {
            // Tìm kiếm theo tên
            return khachHangRepository.findByNameContaining(search, pageable);
        } else if (genderFilter != null && !genderFilter.isEmpty()) {
            // Lọc theo giới tính
            return khachHangRepository.findByGender(genderFilter, pageable);
        } else {
            // Trả về tất cả khách hàng nếu không có tìm kiếm hay lọc
            return khachHangRepository.findAll(pageable);
        }
    }
}
