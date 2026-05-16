package com.hashim.BookingsSystem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private EmployeeRepo employeeRepo;

    public Controller(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @GetMapping("/")
    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    @PostMapping("/addEmp")
    public String addEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return employee.toString() + " added";
    }

    @PatchMapping("/editEmp")
    public String editEmployee(@RequestParam Integer id, @RequestParam  Integer salary)
    {
        Employee employee = employeeRepo.findById(id).orElse(null);
        employee.setSalary(salary);
        return employee.toString();
    }

    @DeleteMapping("/deleteEmp")
    public String deleteEmp(@RequestParam int id){

        employeeRepo.deleteById(id);
        return "deleted !";
    }
}
