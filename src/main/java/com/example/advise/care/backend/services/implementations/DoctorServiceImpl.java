package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.dtos.requests.DoctorSignupDto;
import com.example.advise.care.backend.dtos.responses.doctors.DoctorSignUpResponseDto;
import com.example.advise.care.backend.models.Doctor;
import com.example.advise.care.backend.repositories.DoctorRepository;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.transformers.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorSignUpResponseDto doctorSignUp(DoctorSignupDto doctorSignupDto) {
        Doctor doctor = DoctorTransformer.doctorSignUpRequestDtoToDoctorEntity(doctorSignupDto);

        Doctor savedDoctor = doctorRepository.save(doctor);

        return DoctorTransformer.doctorToDoctorSignUpResponseDto(savedDoctor);
    }

    @Override
    public List<DoctorSignUpResponseDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorSignUpResponseDto> doctorDtos = new ArrayList<>();

        for (Doctor doctor: doctors) {
            doctorDtos.add(DoctorTransformer.doctorToDoctorSignUpResponseDto(doctor));
        }

        return doctorDtos;
    }
}
