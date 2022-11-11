package com.jnsgdm.freelacontrolapi.service;

import com.jnsgdm.freelacontrolapi.persistence.model.Project;
import com.jnsgdm.freelacontrolapi.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void create(Project project) {
        project.setStartDate(LocalDate.now());
        project.applyNetProfit(project);
        projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getOne(Long projectID) {
        return projectRepository.findById(projectID).orElseThrow();
    }

    @Override
    public void delete(Long projectID) {
        projectRepository.deleteById(projectID);
    }

    @Override
    public void update(Project project,Long projectID) {
        Project updateProject = projectRepository.findById(projectID).orElseThrow();

        if(project.getDescription() != null){
            updateProject.setDescription(project.getDescription());
        }
        if(project.getGrossProfit() != null){
            updateProject.setGrossProfit(project.getGrossProfit());
        }
        if(project.getExpenses() != null){
            updateProject.setExpenses(project.getExpenses());
        }
        if(project.getRef() != null){
            updateProject.setRef(project.getRef());
        }
        updateProject.applyNetProfit(updateProject);

        projectRepository.save(updateProject);
    }
}
