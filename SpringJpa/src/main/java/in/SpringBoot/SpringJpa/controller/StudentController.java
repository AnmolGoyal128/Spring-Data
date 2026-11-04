package in.SpringBoot.SpringJpa.controller;

import in.SpringBoot.SpringJpa.entity.Student;
import in.SpringBoot.SpringJpa.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Student created successfully");
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        Student student = studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }
}
