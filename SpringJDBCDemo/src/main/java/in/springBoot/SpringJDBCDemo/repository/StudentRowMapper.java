package in.springBoot.SpringJDBCDemo.repository;

import in.springBoot.SpringJDBCDemo.model.Student;
import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {

        return new Student(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getInt("age")
        );
    }
}