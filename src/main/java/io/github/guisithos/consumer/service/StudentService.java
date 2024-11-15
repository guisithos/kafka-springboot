package io.github.guisithos.consumer.service;

import io.github.guisithos.consumer.model.Student;
import io.github.guisithos.consumer.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    
    @Transactional
    public void processStudent(Student student) {
        validateStudent(student);
        studentRepository.save(student);
    }
    
    private void validateStudent(Student student) {
        // Additional business validations
    }
} 