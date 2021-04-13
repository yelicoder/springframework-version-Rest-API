package com.aiconsulting.swagger4.repository;

import com.aiconsulting.swagger4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
