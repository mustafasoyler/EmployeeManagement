package com.mustafa.employee.service.Impl;

import com.mustafa.employee.model.Employee;
import com.mustafa.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements com.mustafa.employee.service.EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepo.save(employee);
    }

    @Override
    public Employee getById(String id) {
        Optional<Employee> optional = employeeRepo.findById(id);
        Employee employee=null;
        if (optional.isPresent()){
            employee= optional.get();
        }else {
            throw new RuntimeException("İşçi bulunamadi" + id);
        }
            return employee;
    }

    @Override
    public void deleteEmployeeId(String id) {
        this.employeeRepo.deleteById(id);

    }
}
