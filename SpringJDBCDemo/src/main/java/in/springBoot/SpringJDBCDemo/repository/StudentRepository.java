package in.springBoot.SpringJDBCDemo.repository;

import in.springBoot.SpringJDBCDemo.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    //private StudentRowMapper studentRowMapper = new StudentRowMapper();

    private RowMapper<Student> rowMapper =
            new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = """
                insert into student (name, email, age)
                values (?, ?, ?)
                """;

        int rowAffected = jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge());
        if (rowAffected == 1) {
            System.out.println("Create Student Successfully");
        } else {
            System.out.println("Create Student failed");
        }

    }

    public Student findById(Long id) {
        String sql = "select id, name, email, age from student where id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                rowMapper,
                id);

    }

    public void update(Student student, Long id) {
        String sql = """
                update student
                set name = ?, email = ?, age = ?
                where id = ?
                """;

        int rowAffected = jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                id);
        if (rowAffected == 1) {
            System.out.println("Update operation successful");
        } else {
            System.out.println("Updation failed");
        }
    }

    public void deleteById(Long id) {
        String sql = "delete from student where id = ?";

        int rowAffected = jdbcTemplate.update(sql, id);
        if (rowAffected == 1) {
            System.out.println("Delete operation successful");
        } else {
            System.out.println("Deletion failed");
        }
    }

    public List<Student> findAll() {
        String sql = "select id, name, email, age from student";

        List<Student> students = jdbcTemplate.query(
                sql, rowMapper);

        return students;
    }
}

//    private Student mapRowToStudent(java.sql.ResultSet resultSet)
//            throws java.sql.SQLException {
//        return new Student(
//                resultSet.getLong("id"),
//                resultSet.getString("name"),
//                resultSet.getString("email"),
//                resultSet.getInt("age"));
//    }