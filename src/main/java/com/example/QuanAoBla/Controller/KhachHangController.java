package com.example.QuanAoBla.Controller;

import com.example.QuanAoBla.Service.KhachHangService;
import com.example.QuanAoBla.Entity.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping
    public String showCustomerList(
            @RequestParam(required = false) String search, // Tìm kiếm
            @RequestParam(required = false) String genderFilter, // Lọc theo giới tính
            @RequestParam(defaultValue = "0") int page, // Trang hiện tại
            Model model) {

        // Truyền tham số tìm kiếm và lọc cho service
        model.addAttribute("customers", khachHangService.getFilteredCustomers(search, genderFilter, page));
        model.addAttribute("searchQuery", search); // Đưa tham số tìm kiếm vào Model
        model.addAttribute("genderFilter", genderFilter); // Đưa tham số lọc giới tính vào Model

        return "customer-list"; // Trả về view danh sách khách hàng
    }
    @GetMapping("/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("khachHang", new KhachHang()); // Truyền một đối tượng KhachHang rỗng cho form
        return "add-customer"; // Trả về trang form thêm khách hàng
    }

    @PostMapping("/add")
    public String addCustomer(KhachHang khachHang) {
        khachHangService.addCustomer(khachHang); // Lưu khách hàng vào cơ sở dữ liệu
        return "redirect:/customers"; // Chuyển hướng về danh sách khách hàng
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomerForm(@PathVariable Integer id, Model model) {
        KhachHang khachHang = khachHangService.getCustomerById(id); // Lấy khách hàng theo ID
        model.addAttribute("khachHang", khachHang); // Truyền khách hàng vào form
        return "edit-customer"; // Trả về form sửa khách hàng
    }

    @PostMapping("/edit")
    public String editCustomer(KhachHang khachHang) {
        khachHangService.updateCustomer(khachHang); // Cập nhật thông tin khách hàng
        return "redirect:/customers"; // Chuyển hướng về danh sách khách hàng
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        khachHangService.deleteCustomer(id); // Xóa khách hàng theo ID
        return "redirect:/customers"; // Chuyển hướng về danh sách khách hàng
    }

}
