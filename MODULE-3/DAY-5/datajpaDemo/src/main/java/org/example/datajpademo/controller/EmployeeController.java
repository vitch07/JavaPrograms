package org.example.datajpademo.controller;


import jakarta.validation.Valid;
import org.example.datajpademo.model.Employee;
import org.example.datajpademo.model.Project;
import org.example.datajpademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
    @GetMapping("/{id}/projects")
    public ResponseEntity<List<Project>> get(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getProjectsByEmployeeId(Math.toIntExact(id)));
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    @PostMapping("/assignProject/{pid}/{eid}")
    public ResponseEntity<String> assignProject(@PathVariable Long pid, @PathVariable Long eid){
        employeeService.assignProject(pid, eid);
        return ResponseEntity.ok("Project assigned to employee successfully");
    }


}
