package com.example.dioclass.rdswithapirest.Hateoas.Repositories;

import com.example.dioclass.rdswithapirest.Hateoas.Entitys.OrderHateoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryHateoas extends JpaRepository<OrderHateoas, Long> {
}