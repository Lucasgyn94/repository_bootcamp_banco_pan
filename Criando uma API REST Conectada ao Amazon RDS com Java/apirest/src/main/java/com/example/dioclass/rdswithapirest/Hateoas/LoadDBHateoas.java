package com.example.dioclass.rdswithapirest.Hateoas;

import com.example.dioclass.rdswithapirest.Hateoas.Entitys.EmployeeHateoas;
import com.example.dioclass.rdswithapirest.Hateoas.Entitys.OrderHateoas;
import com.example.dioclass.rdswithapirest.Hateoas.Entitys.Status;
import com.example.dioclass.rdswithapirest.Hateoas.Repositories.EmployeeRepositoryHateoas;
import com.example.dioclass.rdswithapirest.Hateoas.Repositories.OrderRepositoryHateoas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class LoadDBHateoas {
    private static final Logger log = LoggerFactory.getLogger(LoadDBHateoas.class);
    // persistindo dados no banco com jpa

    @Bean
    CommandLineRunner loaddata(EmployeeRepositoryHateoas employeeRepositoryHateoas, OrderRepositoryHateoas orderRepositoryHateoas) {
        return args -> {
            log.info("Log of save event: " + employeeRepositoryHateoas.save(new EmployeeHateoas("Maria Silva", "Chef",
                    "avenida silveira dutra 1002")));
            log.info("log of save event: " + employeeRepositoryHateoas.save(new EmployeeHateoas("John Dutra", "Mecanico",
                    "rua joao freire 231")));
            log.info("Log of save event: " + employeeRepositoryHateoas.save(new EmployeeHateoas("Bilbo Baggins", "thief",
                    "The shine")));
            orderRepositoryHateoas.save(new OrderHateoas(Status.COMPLETED, "review"));
            orderRepositoryHateoas.save(new OrderHateoas(Status.IN_PROGRESS, "travel"));
            orderRepositoryHateoas.save(new OrderHateoas(Status.IN_PROGRESS, "sale"));
            orderRepositoryHateoas.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}