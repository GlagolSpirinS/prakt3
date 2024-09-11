package com.example.project2.repository;

import com.example.project2.model.FacultyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyModelRepository extends

        JpaRepository<FacultyModel,Long> {
}
