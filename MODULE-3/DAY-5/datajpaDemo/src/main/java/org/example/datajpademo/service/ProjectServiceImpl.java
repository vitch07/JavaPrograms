package org.example.datajpademo.service;

import jakarta.annotation.PostConstruct;
import org.example.datajpademo.exception.ErrorResponse;
import org.example.datajpademo.exception.GlobalExceptionHandler;
import org.example.datajpademo.exception.ProjectNotFound;
import org.example.datajpademo.exception.ResourceNotFoundException;
import org.example.datajpademo.model.Employee;
import org.example.datajpademo.model.Project;
import org.example.datajpademo.repository.EmployeeRepository;
import org.example.datajpademo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository projectRepo;

    private EmployeeRepository employeeRepo;
    ProjectServiceImpl(ProjectRepository projectRepo,EmployeeRepository employeeRepo){
        this.projectRepo = projectRepo;
        this.employeeRepo = employeeRepo;
    }

    @PostConstruct
    public void init(){

    }

    @Override
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepo.findAll();
    }

    @Override
    public void updateById(Long id, Project project) {
            Project existing = projectRepo.findById(id).orElse(null);
            if(existing != null){
                existing.setProjectName(project.getProjectName());
                projectRepo.save(existing);
            }
    }

    @Override
    public void deleteById(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        projectRepo.deleteAll();
    }

    @Override
    public String assignProject(Long pid, Long cid) {

        Project project = projectRepo.findById(pid).orElse(null);
        Employee client = employeeRepo.findById(cid).orElseThrow(
                () -> new ResourceNotFoundException("Resource Not found exception"));
        if(project == null) {
            return "Project not found";
        }

        if(client == null) {
            return "Client not found";
        }
        client.getProjectList().add(project);
        projectRepo.save(project);
        return "Project assigned successfully";
    }

    @Override
    public List<Project> getProjectsByEmployeeId(Long id){
        Employee emp = employeeRepo.findById(id).orElse(null);
        if(emp == null){
            throw new ProjectNotFound("Employee not found");
        }
        return emp.getProjectList();
    }
}
