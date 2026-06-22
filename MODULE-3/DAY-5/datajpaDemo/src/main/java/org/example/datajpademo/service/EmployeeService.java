package org.example.datajpademo.service;

import org.example.datajpademo.model.Employee;
import org.example.datajpademo.model.Project;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public List<Employee> getAll();
    public Employee getById(Long id);
    public void deleteById(Long id);
    public void assignProject(Long pid, Long eid);
    public List<Project> getProjectsByEmployeeId(int id);
}