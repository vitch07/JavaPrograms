package org.example.datajpademo.controller;


import org.example.datajpademo.model.Employee;
import org.example.datajpademo.model.Project;
import org.example.datajpademo.service.EmployeeService;
import org.example.datajpademo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/projects")
    public ResponseEntity<Project> addingProject(@RequestBody Project project) {
        Project savedProject = projectService.addProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> gettingProjectById(@PathVariable Long id) {
        Project project = projectService.findById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> gettingAllProjects() {
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @DeleteMapping("/projects/delete")
    public ResponseEntity<Void> deleteAllItems(){
        projectService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/projects/getProjectsByEmployeeId/{id}")
    public ResponseEntity<List<Project>> getProjectsByEmployeeId(@PathVariable Long id){
        List<Project> projects = projectService.getProjectsByEmployeeId(id);
        if (projects.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}