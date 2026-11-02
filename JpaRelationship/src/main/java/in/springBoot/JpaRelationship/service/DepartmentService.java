package in.springBoot.JpaRelationship.service;

import in.springBoot.JpaRelationship.entity.Department;
import in.springBoot.JpaRelationship.entity.Student;
import in.springBoot.JpaRelationship.repository.DepartmentRepository;
import in.springBoot.JpaRelationship.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }
    @Transactional
    public void createDepartment(Department department, String studentName) {

        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);

        department.getStudentList().add(student);

        studentRepository.save(student);
        departmentRepository.save(department);
    }
}
