package com.example.project2.repository;

import com.example.project2.model.PersonaDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonaDataModel,Long> {
}
