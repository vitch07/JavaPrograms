package org.example.datajpademo.service;

import org.example.datajpademo.model.Employee;
import org.example.datajpademo.model.Project;
import org.example.datajpademo.repository.EmployeeRepository;
import org.example.datajpademo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById((long) Math.toIntExact(id)).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById((long) Math.toIntExact(id));
    }
    @Override
    public void assignProject(Long pid, Long eid) {
        Project existing = projectRepository.findById((long) Math.toIntExact(pid)).orElse(null);
        if(existing != null){
            Employee employee = employeeRepository.findById((long) Math.toIntExact(eid)).orElse(null);
            if(employee != null){
                existing.getEmployeeList().add(employee);
                employee.getProjectList().add(existing);
                projectRepository.save(existing);
                employeeRepository.save(employee);
            }
        }
    }
    @Override
    public List<Project> getProjectsByEmployeeId(int id) {

        Employee employee = employeeRepository.findById((long) id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        return employee.getProjectList();
    }
}
