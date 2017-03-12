package com.example.repo;

import com.example.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by DEK on 12/03/2017.
 */
public interface ModuleRepo extends JpaRepository<Module,Long> {

    @Query("SELECT m FROM Module m WHERE m.project.id = :id")
    List<Module> findModuleByProjectId(@Param("id") Long id);
}
