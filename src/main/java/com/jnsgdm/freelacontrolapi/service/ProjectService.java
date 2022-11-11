package com.jnsgdm.freelacontrolapi.service;

import com.jnsgdm.freelacontrolapi.persistence.model.Project;

import java.util.List;

public interface ProjectService {
    void create(Project project);

    List<Project> getAll();

    Project getOne(Long projectID);

    void delete(Long projectID);

    void update(Project project,Long projectID);
}
