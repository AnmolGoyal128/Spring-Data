package in.springBoot.Hibernate.service;

import in.springBoot.Hibernate.model.Student;
import in.springBoot.Hibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }
    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);
        if (student != null) {
            studentRepository.deleteById(student);
        }
    }

//    @Transactional
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }

    @Transactional
    public Student updateStudent(Long id, Student studentReq){
        Student student1 = studentRepository.findById(id);

        student1.setName(studentReq.getName());
        student1.setEmail(studentReq.getEmail());
        student1.setAge(studentReq.getAge());
        return student1;

    }
}
