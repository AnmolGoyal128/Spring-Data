package in.SpringBoot.Repository;

import in.SpringBoot.model.Student;

import java.sql.*;

public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "anmol@128";

    public void createUser(){
        try {

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

            String sql = "Insert INTO students(name, email, age) " +
                    "VALUES ('Anmol', 'an@gmail.com', 19)";

        int result = statement.executeUpdate(sql);

        if (result == 1) {
            System.out.println("Create Connection successful");
        }
        else {
            System.out.println("Create Connection failed");
        }
        // System.out.println("Connected to database successfully");

        connection.close();
        }
        catch (SQLException ex) {
            System.out.println("Database connection failed");
            ex.printStackTrace();

        }

    }

    public void updateUser(){

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "UPDATE students SET age = 20 " +
                    "WHERE id = 1";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Update Operation successful");
            }
            else {
                System.out.println("Updation failed");
            }
            // System.out.println("Connected to database successfully");

            connection.close();
        }catch (SQLException ex) {
            System.out.println("Database connection failed");
            ex.printStackTrace();

        }

    }

    public void deleteUser(){
        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "DELETE FROM students WHERE id = 1";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Delete Operation successful");
            }
            else {
                System.out.println("Deletion failed");
            }
            // System.out.println("Connected to database successfully");

            connection.close();
        }catch (SQLException ex) {
            System.out.println("Database connection failed");
            ex.printStackTrace();

        }
    }

    public void getUserById(){
        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age FROM students WHERE id = 2";

            ResultSet result = statement.executeQuery(sql);

            result.next();

            Student student = mapRow(result);

            System.out.println(student);

            // System.out.println("Connected to database successfully");

            connection.close();
        }catch (SQLException ex) {
            System.out.println("Database connection failed");
            ex.printStackTrace();

        }
    }

    private Student mapRow(ResultSet result) throws SQLException {
        Student student = new Student();
        student.setId(result.getLong("id"));
        student.setName(result.getString("name"));
        student.setAge(result.getInt("age"));
        student.setEmail(result.getString("email"));

        return student;
    }

    public void CompleteCrud(){
        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age FROM students WHERE id = 2";

            boolean result = statement.execute(sql);

            if(result){
            ResultSet resultSet = statement.getResultSet();
            }else{
                int rowAffected = statement.getUpdateCount();
            }
            connection.close();
        }catch (SQLException ex) {
        System.out.println("Database connection failed");
        ex.printStackTrace();

    }

}

