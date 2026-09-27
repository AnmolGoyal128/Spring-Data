package in.SpringBoot.Repository;

import in.SpringBoot.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "anmol@128";


    String sql = """
                    INSERT INTO students(name, email, age)
                    VALUES (?, ?, ?)
                    """;

    public void createUser(Student student) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {

        //Statement statement = connection.createStatement();
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setInt(3, student.getAge());

        int rowaffected = preparedStatement.executeUpdate();

        if (rowaffected > 0) {
            System.out.println("Successfully inserted " + student.getName());
        }else {
            System.out.println("Failed to insert " + student.getName());
        }



        //int result = statement.executeUpdate(sql);

//        if (result == 1) {
//            System.out.println("Create Connection successful");
//        }
//        else {
//            System.out.println("Create Connection failed");
//        }
//        // System.out.println("Connected to database successfully");

        connection.close();
        }
        catch (SQLException ex) {
            System.out.println("Database connection failed");
            ex.printStackTrace();

        }
//        finally {
//            try{
//                preparedStatement.close();
//            }
//            catch (SQLException ex){
//                ex.printStackTrace();
//            }
//            try{
//                connection.close();
//            }
//            catch (SQLException ex){
//                ex.printStackTrace();
//            }
//        }

    }

    public void updateUser(Student student, Long id) {

        String sql = "UPDATE students SET name = ? , email = ?, age = ? WHERE id = ?";

         // Try with resourses
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);


           // Statement statement = connection.createStatement();


            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 1) {
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

    public void deleteUser(Long id) {

        String sql = "DELETE FROM students WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);) {


            //Statement statement = connection.createStatement();

            preparedStatement.setLong(1, id);




            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 1) {
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

    public void getUserById(Long id) {

        String sql = "SELECT id, name, email, age FROM students WHERE id = ?";


        try(Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);){

            preparedStatement.setLong(1, id);




            try(ResultSet resultSet = preparedStatement.executeQuery();){

                if(resultSet.next()){

                    Student student = mapRow(resultSet);

                    System.out.println(student);

                }
            }
            // System.out.println("Connected to database successfully");

            connection.close();
        }catch (SQLException ex) {
            System.out.println("Database connection failed");
            ex.printStackTrace();

        }
    }

    public void getAllUsers() {
        String sql = "SELECT id, name, email, age FROM students";

        try(Connection connection = DriverManager.getConnection(url, username,password );
        PreparedStatement preparedStatement = connection.prepareStatement(sql);)

        {
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                List<Student> studentList = new ArrayList<>();

                while (resultSet.next()){
                    Student student = mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);
                }
            }

            }
        catch (SQLException ex) {
            ex.printStackTrace();



        }
    }

    public void CompleteCrud() {
        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age FROM students WHERE id = 2";

            boolean result = statement.execute(sql);

            if (result) {
                ResultSet resultSet = statement.getResultSet();
            } else {
                int rowAffected = statement.getUpdateCount();
            }
            connection.close();
        } catch (SQLException ex) {
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
}

