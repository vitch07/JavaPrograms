package org.example.datajpademo.service;

import org.example.datajpademo.model.Project;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface ProjectService {

    Project addProject(Project project);
    Project findById(Long id);
    List<Project> findAll();
    List<Project> getAllProject();
    void updateById(Long id,Project project);
    void deleteById(Long id);
    void deleteAll();
    String  assignProject(Long pid,Long eid);
    List<Project> getProjectsByEmployeeId(Long id);
}
