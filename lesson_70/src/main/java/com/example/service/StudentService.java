package com.example.service;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO crate(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        studentRepository.saveStudent(entity);
        dto.setId(entity.getId());
        return dto;
    }
}
