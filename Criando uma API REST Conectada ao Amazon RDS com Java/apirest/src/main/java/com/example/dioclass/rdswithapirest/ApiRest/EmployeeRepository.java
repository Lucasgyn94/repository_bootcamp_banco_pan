package com.example.dioclass.rdswithapirest.ApiRest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // classe abstrata
}
