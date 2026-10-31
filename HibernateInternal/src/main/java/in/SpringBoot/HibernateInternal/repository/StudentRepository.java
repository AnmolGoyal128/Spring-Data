package in.SpringBoot.HibernateInternal.repository;

import in.SpringBoot.HibernateInternal.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Create
    public void save(Student student){
        entityManager.persist(student);
    }

    public void saveAll(List<Student> students){

        int counter = 0;
        for (Student student : students){

            entityManager.persist(student);
            counter ++;
            if(counter % 100 == 0){
                entityManager.flush();
                entityManager.clear();
                entityManager.refresh(student);
            }


        }
    }
    // read
    public Student findById(Long id){
        Student s1 = entityManager.find(Student.class, id);
        // entityManager.detach(s1);
        entityManager.contains(s1);
        return s1;
    }

    // delete
    public void deleteById(Student student){
        entityManager.remove(student);
    }

    // merge

    public Student attachAgain(Student student){
        return entityManager.merge(student);
    }
    // detach

    public void detach(Student student){
        entityManager.detach(student);
    }

    // flussh
    public void flush(){
        entityManager.flush();
    }
}
