package com.example.dioclass.rdswithapirest.Hateoas.Repositories;


import com.example.dioclass.rdswithapirest.Hateoas.Entitys.EmployeeHateoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryHateoas extends JpaRepository<EmployeeHateoas, Long> {

}