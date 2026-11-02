package in.springBoot.JpaRelationship.repository;

import in.springBoot.JpaRelationship.entity.Department;
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

    public Department getDepartmentById(Long departmentId) {
        return entityManager.find(Department.class, departmentId);
    }
}
