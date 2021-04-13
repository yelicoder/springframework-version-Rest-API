package com.aiconsulting.swagger4.controller;

import com.aiconsulting.swagger4.model.Employee;
import com.aiconsulting.swagger4.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> findAllEmployee() {
            return employeeRepository.findAll();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody final Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public Employee findByIdEmployee(@PathVariable Long id){
        return employeeRepository.getOne(id);
    }

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Employee saveEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee existingEmployee = employeeRepository.getOne(id);
        BeanUtils.copyProperties(employee, existingEmployee, "employeeId");
        return employeeRepository.saveAndFlush(existingEmployee);
    }



}
