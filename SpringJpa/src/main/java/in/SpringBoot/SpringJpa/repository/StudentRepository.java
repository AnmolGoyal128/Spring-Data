package in.SpringBoot.SpringJpa.repository;

import in.SpringBoot.SpringJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

}
