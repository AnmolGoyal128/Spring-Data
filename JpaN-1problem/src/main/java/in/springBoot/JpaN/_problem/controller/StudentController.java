package in.springBoot.JpaN._problem.controller;

import in.springBoot.JpaN._problem.entity.Student;
import in.springBoot.JpaN._problem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam Long department_id) {
        // Implementation for creating a new student
        studentService.createStudent(student, department_id);
        return ResponseEntity.ok("Student created successfully");
    }

//    @PostMapping("/withDepartment")
//    public ResponseEntity<String> createStudent(@RequestBody Student student,
//                                                @RequestParam String deptName) {
//        // Implementation for creating a new student
//        studentService.createStudent(student, deptName);
//        return ResponseEntity.ok("Student created successfully");
//    }
}
