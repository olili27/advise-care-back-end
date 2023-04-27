package com.example.advise.care.backend.repositories;

import com.example.advise.care.backend.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public Patient findByEmailId(String emailId);
}
