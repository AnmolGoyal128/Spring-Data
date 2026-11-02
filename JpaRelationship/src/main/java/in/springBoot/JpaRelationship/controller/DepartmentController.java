package in.springBoot.JpaRelationship.controller;

import in.springBoot.JpaRelationship.entity.Department;
import in.springBoot.JpaRelationship.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {

        departmentService.createDepartment(department);
        return ResponseEntity.ok("Department created successfully");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String> createDepartment(@RequestBody Department department,
                                                   @RequestParam String studentName
                                                   ) {

        departmentService.createDepartment(department, studentName);
        return ResponseEntity.ok("Department created successfully");
    }
}
