package in.springBoot.JpaN._problem.service;

import in.springBoot.JpaN._problem.entity.Department;
import in.springBoot.JpaN._problem.entity.Student;
import in.springBoot.JpaN._problem.repository.DepartmentRepository;
import in.springBoot.JpaN._problem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    //DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository
                          ) {
        this.studentRepository = studentRepository;
        //this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long department_id) {



    }
}

//        Department department =
//                departmentRepository.getDepartmentById(department_id);
//
//        department.getStudentList().add(student);
//
//
//        student.setDepartment(department);
//        studentRepository.save(student);
//
//    }
//    @Transactional
//    public void createStudent(Student student, String deptName) {
//
//        Department department = new Department();
//        department.setName(deptName);
//
//        department.getStudentList().add(student);
//
//        student.setDepartment(department);
//
//        departmentRepository.save((department));
//        studentRepository.save(student);
//    }