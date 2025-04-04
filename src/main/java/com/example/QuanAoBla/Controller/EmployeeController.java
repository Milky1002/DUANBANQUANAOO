package com.example.QuanAoBla.Controller;

import com.example.QuanAoBla.Entity.Employee;
import com.example.QuanAoBla.Entity.Users;
import com.example.QuanAoBla.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list"; // Trả về tên view
    }
    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model) {
        return "add-employee";
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestParam("fullName") String fullName,
                              @RequestParam("position") String position,
                              @RequestParam("hireDate") String hireDate,
                              @RequestParam("salary") Double salary,
                              @RequestParam("email") String email,
                              @RequestParam("phone") String phone,
                              @RequestParam("isActive") Boolean isActive) {

        Users user = new Users();
        user.setEmail(email);
        user.setPhone(phone);

        Employee employee = new Employee();
        employee.setFullName(fullName);
        employee.setPosition(position);
        employee.setHireDate(LocalDate.parse(hireDate));
        employee.setSalary(salary);
        employee.setIsActive(isActive);
        employee.setUser(user);

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }
}
