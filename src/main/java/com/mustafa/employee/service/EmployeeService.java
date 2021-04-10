package com.mustafa.employee.service;

import com.mustafa.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    void save(Employee employee);
    Employee getById(String id);
    void deleteEmployeeId(String id);
}
