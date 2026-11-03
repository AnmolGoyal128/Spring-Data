package in.springBoot.JpaN._problem.service;

import in.springBoot.JpaN._problem.entity.Department;
import in.springBoot.JpaN._problem.entity.Student;
import in.springBoot.JpaN._problem.repository.DepartmentRepository;
import in.springBoot.JpaN._problem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.aot.hint.TypeReference.listOf;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {

        Student s1 = new Student();
        s1.setName("Aditya");
        s1.setDepartment(department);
        //department.getStudentList().add(s1);
        //studentRepository.save(s1);

        Student s2 = new Student();
        s2.setName("Rohit");
        s2.setDepartment(department);
        //department.getStudentList().add(s2);
        //studentRepository.save(s2);

        Student s3 = new Student();
        s3.setName("Rohan");
        s3.setDepartment(department);
        //department.getStudentList().add(s3);
        //studentRepository.save(s3);

        Student s4 = new Student();
        s4.setName("Rahul");
        s4.setDepartment(department);
        //department.getStudentList().add(s4);
        //studentRepository.save(s4);

        department.getStudentList().addAll(List.of(s1, s2, s3, s4));

//        departmentRepository.save(department);
//        studentRepository.save(s1);
//        studentRepository.save(s2);
//        studentRepository.save(s3);
//        studentRepository.save(s4);
    }
//    @Transactional
//    public void createDepartment(Department department, String studentName) {
//
//        Student student = new Student();
//        student.setName(studentName);
//        student.setDepartment(department);
//
//        department.getStudentList().add(student);
//
//        studentRepository.save(student);
//        departmentRepository.save(department);
//    }

    @Transactional
    public void remove(Long deptid){
        Department department = departmentRepository.findById(deptid);
        departmentRepository.remove(department);
    }
}
