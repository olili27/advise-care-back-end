package com.example.advise.care.backend.repositories;

import com.example.advise.care.backend.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    public Doctor findByEmailId(String emailId);
}
