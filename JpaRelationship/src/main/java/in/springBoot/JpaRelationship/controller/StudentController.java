package in.springBoot.JpaRelationship.controller;

import in.springBoot.JpaRelationship.entity.Student;
import in.springBoot.JpaRelationship.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{deptid}")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam Long department_id) {
        // Implementation for creating a new student
        studentService.createStudent(student, department_id);
        return ResponseEntity.ok("Student created successfully");
    }
}
