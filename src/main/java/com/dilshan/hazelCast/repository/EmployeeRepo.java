package com.dilshan.hazelCast.repository;

import com.dilshan.hazelCast.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
