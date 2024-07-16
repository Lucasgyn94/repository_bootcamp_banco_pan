package com.example.dioclass.rdswithapirest.myFirstApi;

import com.example.dioclass.rdswithapirest.myFirstApi.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // classe abstrata - não precisa implementar
}
