package org.kol.backend.service;

import jakarta.transaction.Transactional;
import org.kol.backend.exception.UserNotFoundException;
import org.kol.backend.model.Employee;
import org.kol.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {


    @Autowired
   // private final EmployeeRepository employeeRepository;
    private  EmployeeRepository employeeRepository;

//    @Autowired
//    public EmployeeService(EmployeeRepo employeeRepo) {
//        this.employeeRepo = employeeRepo;
//    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
