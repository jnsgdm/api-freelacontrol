package com.jnsgdm.freelacontrolapi.persistence.repository;

import com.jnsgdm.freelacontrolapi.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
