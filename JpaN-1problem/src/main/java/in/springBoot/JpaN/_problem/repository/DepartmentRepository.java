package in.springBoot.JpaN._problem.repository;

import in.springBoot.JpaN._problem.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

//    public Department getDepartmentById(Long departmentId) {
//        return entityManager.find(Department.class, departmentId);
//    }
    public void remove(Department department){
        entityManager.remove(department);
    }

    public Department findById(Long deptid) {
        return entityManager.find(Department.class, deptid);
    }
}
