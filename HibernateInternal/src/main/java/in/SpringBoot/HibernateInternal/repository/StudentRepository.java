package in.SpringBoot.HibernateInternal.repository;

import in.SpringBoot.HibernateInternal.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Create
    public void save(Student student){
        entityManager.persist(student);
    }

    // read
    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

    // delete
    public void deleteById(Student student){
        entityManager.remove(student);
    }
}
