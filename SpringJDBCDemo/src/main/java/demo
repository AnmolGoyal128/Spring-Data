package in.springBoot.SpringJDBCDemo.repository;

import in.springBoot.SpringJDBCDemo.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static final String url = "jdbc:mysql://localhost:3306/springjdbc";
    private static final String user = "root";
    private static final String password = "root";

    // Insert a student

    public int save(Student student) {
        String sql = "insert into student (name, email, age) " +
                "values (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setObject(3, student.getAge());
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Failed to save student: "
                            + e.getMessage(), e);
        }
    }

    // Find a student by ID

    public Student findById(Long id) {
        String sql = "select * from student where id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.
                    setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Student student = mapRowToStudent(resultSet);
                return student;
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//                Integer age = resultSet.getInt("age");
//                return new Student(id, name, email, age);
            } else {
                return null; // Student not found
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Failed to find student by ID: "
                            + e.getMessage(), e);
        }
    }

    // Update a student

    public int update(Student student, Long id) {
        String sql = "update student set name = ?, email = ?, age = ? where id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setObject(3, student.getAge());
            preparedStatement.setLong(4, student.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Failed to update student: "
                            + e.getMessage(), e);
        }
    }

    // Delete a student by ID

    public int deleteById(Long id) {
        String sql = "delete from student where id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Failed to delete student by ID: "
                            + e.getMessage(), e);
        }
    }

    // Get all students

    public List<Student> findAll() {
        String sql = "select * from student";
        List<Student> students = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = mapRowToStudent(resultSet);
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Failed to retrieve all students: "
                            + e.getMessage(), e);
        }

        return students;
    }

    private Student mapRowToStudent(ResultSet resultSet) {
        try {
            return new Student(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("age")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Failed to map row to student: " + e.getMessage(), e);
        }
    }

}
