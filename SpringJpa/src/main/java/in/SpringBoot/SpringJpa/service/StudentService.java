package in.SpringBoot.SpringJpa.service;

import in.SpringBoot.SpringJpa.entity.Student;
import in.SpringBoot.SpringJpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        // Logic to save the student entity to the database
        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id) {
        // Logic to fetch a student entity by its ID from the database
        return studentRepository.findById(id).orElse(null);
    }

}
