package in.SpringBoot.SpringJpa.service;

import in.SpringBoot.SpringJpa.entity.Student;
import in.SpringBoot.SpringJpa.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Student> fetchAllStudents(String name) {
        // Logic to fetch all student entities from the database

        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<Student> studentList =
                studentRepository.findAll(sort);
        return studentList;
    }

    Pageable pageable = PageRequest.of(0,2);

    Page<Student> studentList =
            studentRepository.findAll(pageable);

//    for(Student s : studentList.getContent()) {
//        System.out.println(s);
//    }


}
