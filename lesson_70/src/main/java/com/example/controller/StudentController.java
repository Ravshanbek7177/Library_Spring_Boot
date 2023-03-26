package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.service.CommandLineRunnerImpl;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private List<StudentDTO> studentList = new LinkedList<>();

    public StudentController() {
        StudentDTO s1 = new StudentDTO();
        s1.setId(1);
        s1.setName("Alish");
        s1.setSurname("Aliyev");

        studentList.add(s1);
    }

    @GetMapping("/list")
    public List<StudentDTO> getAll() {
        return studentList;
    }

    @GetMapping(value = "/get/{id}")
    public StudentDTO getById(@PathVariable("id") String id) {
        Optional<StudentDTO> optional = studentList.stream().filter(studentDTO -> studentDTO.getId().equals(id)).findAny();
        return optional.orElse(null);
    }

    @PostMapping(value = "/create")
    public StudentDTO create(@RequestBody StudentDTO studentDTO) {
        return studentService.crate(studentDTO);
    }

    @PostMapping(value = "/create/all")
    public Boolean createAll(@RequestBody List<StudentDTO> list) {
        for (StudentDTO dto : list) {
            dto.setId(1);
            studentList.add(dto);
        }
        return true;
    }

    @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody StudentDTO studentDTO) {
        for (StudentDTO dto : studentList) {
            if (dto.getId().equals(id)) {
                dto.setName(studentDTO.getName());
                dto.setSurname(studentDTO.getSurname());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable("id") String id) {
        return studentList.removeIf(studentDTO -> studentDTO.getId().equals(id));
    }
}
