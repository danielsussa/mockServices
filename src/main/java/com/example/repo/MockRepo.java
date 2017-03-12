package com.example.repo;

import com.example.entity.Mock;
import com.example.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by DEK on 12/03/2017.
 */
public interface MockRepo extends JpaRepository<Mock,Long>{
    @Query("SELECT m FROM Mock m WHERE m.request = :request")
    List<Mock> findMockByRequest(@Param("request") String request);
}
