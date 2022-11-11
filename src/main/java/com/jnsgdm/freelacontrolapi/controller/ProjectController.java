package com.jnsgdm.freelacontrolapi.controller;

import com.jnsgdm.freelacontrolapi.dto.ProjectDto;
import com.jnsgdm.freelacontrolapi.persistence.model.Project;
import com.jnsgdm.freelacontrolapi.response.ResponseHandler;
import com.jnsgdm.freelacontrolapi.service.ProjectServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectService;

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody ProjectDto projectDto){
        try {
            Project projectEntity = new Project();
            BeanUtils.copyProperties(projectDto,projectEntity);
            projectService.create(projectEntity);
            return ResponseHandler.generateResponse("Project created!",HttpStatus.OK,projectDto);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllProjects(){
        try{
            List<Project> projects = projectService.getAll();
            return ResponseHandler.generateResponse("Successfully retrieved!",HttpStatus.OK,projects);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping(value = "/{projectID}")
    public ResponseEntity<Object> getOne(@PathVariable Long projectID){
        try{
            Project project = projectService.getOne(projectID);
            return ResponseHandler.generateResponse("Successfully retrieved!",HttpStatus.OK,project);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PatchMapping(value = "/{projectID}")
    public ResponseEntity<Object> updateProject(@RequestBody ProjectDto projectDto, @PathVariable Long projectID){
        try{
            Project projectEntity = new Project();
            BeanUtils.copyProperties(projectDto,projectEntity);
            projectService.update(projectEntity,projectID);
            return ResponseHandler.generateResponse("Project updated!",HttpStatus.OK,"Updated id: "+projectID);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @DeleteMapping(value = "/{projectID}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long projectID){
        try{
            projectService.delete(projectID);
            return ResponseHandler.generateResponse("Project deleted!",HttpStatus.OK,"Deleted id: "+projectID);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
}
