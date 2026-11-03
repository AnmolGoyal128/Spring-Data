package in.springBoot.JpaN._problem.controller;

import in.springBoot.JpaN._problem.entity.Department;
import in.springBoot.JpaN._problem.service.DepartmentService;
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
    public ResponseEntity<String> createDepartment(
            @RequestBody Department department) {

        departmentService.createDepartment(department);
        return ResponseEntity.ok("Department created successfully");
    }

//    @PostMapping("/withStudent")
//    public ResponseEntity<String> createDepartment(@RequestBody Department department,
//                                                   @RequestParam String studentName
//                                                   ) {
//
//        departmentService.createDepartment(department, studentName);
//        return ResponseEntity.ok("Department created successfully");
//    }

    @DeleteMapping
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.remove(id);
        return ResponseEntity.ok("Department deleted successfully");
    }
}
