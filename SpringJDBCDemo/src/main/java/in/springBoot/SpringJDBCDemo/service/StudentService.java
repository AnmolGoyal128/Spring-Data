package in.springBoot.SpringJDBCDemo.service;

import in.springBoot.SpringJDBCDemo.model.Student;
import in.springBoot.SpringJDBCDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.update(student, student.getId());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
