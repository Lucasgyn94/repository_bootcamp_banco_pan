package com.example.dioclass.rdswithapirest.ApiRest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeRepository repository;

    public EmployeeController (EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String apiRest(){

        return "Essa e a minha api REST com Spring Boot";
    }

    @GetMapping("/employees")
    public List<Employee> listOfEmployeeAll () {
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee consultById (@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // modificação parcial
    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, Long id) {
        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setAddress(newEmployee.getAddress());
            employee.setRole(newEmployee.getRole());
            return  repository.save(newEmployee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return  repository.save(newEmployee);
        });
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
