package com.task.Employee.Service.controller;

import com.task.Employee.Service.model.dto.EmployeeDto;
import com.task.Employee.Service.model.entity.Employee;
import com.task.Employee.Service.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private final EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/getAll")          //localhost:9090/employee/getAll?pageNo=0&pageSize=5
    public List<EmployeeDto> getAllEmployees(@RequestParam int pageNo , @RequestParam int pageSize){
        return employeeService.viewAllEmployees(pageNo, pageSize);
    }
    @GetMapping("/view/{id}")
    public EmployeeDto viewEmployee(@PathVariable int id){
        return employeeService.viewEmployee(id);
    }

    @PutMapping("/update")
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
