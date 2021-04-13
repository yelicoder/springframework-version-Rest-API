package com.aiconsulting.swagger4.controller;

import com.aiconsulting.swagger4.model.Employee;
import com.aiconsulting.swagger4.repository.EmployeeRepository;
import com.aiconsulting.swagger4.service.EmployeeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployee(
            @RequestParam(defaultValue="0") Integer pageNo,
            @RequestParam(defaultValue="10") Integer pageSize,
            @RequestParam(defaultValue="employeeId") String sortBy
            )
    {
        List<Employee> List = employeeService.findAllEmployees(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<Employee>>(List, new HttpHeaders(), HttpStatus.OK);

    }
}
