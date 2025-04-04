package com.example.QuanAoBla.Service;

import com.example.QuanAoBla.Entity.Employee;
import com.example.QuanAoBla.Entity.Users;
import com.example.QuanAoBla.Repository.EmployeeRepository;
import com.example.QuanAoBla.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UsersRepository usersRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public void saveEmployee(Employee employee) {
            Users user = employee.getUser();
            if (user != null) {
                usersRepository.save(user);
            }

            employeeRepository.save(employee);    }
}
