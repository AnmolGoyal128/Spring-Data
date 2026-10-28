package in.springBoot.SpringJDBCDemo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/springjdbc";
    String user = "root";
    String password = "root";
}
