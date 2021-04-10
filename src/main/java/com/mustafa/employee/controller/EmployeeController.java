package com.mustafa.employee.controller;

import com.mustafa.employee.model.Employee;
import com.mustafa.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAll());
        return "index" ;
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model){
        Employee employee= employeeService.getById(id);
        model.addAttribute("employee",employee);
        return "update_employee";

    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id){
        this.employeeService.deleteEmployeeId(id);
        return "redirect:/";

    }
}
