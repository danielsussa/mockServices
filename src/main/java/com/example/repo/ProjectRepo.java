package com.example.repo;

import com.example.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DEK on 12/03/2017.
 */
public interface ProjectRepo extends JpaRepository<Project,Long> {
}
