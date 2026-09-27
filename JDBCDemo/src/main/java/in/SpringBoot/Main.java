package in.SpringBoot;

import in.SpringBoot.Repository.StudentRepository;
import in.SpringBoot.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {
        System.out.println("Hello World");

       StudentRepository studentRepository = new StudentRepository();

        //studentRepository.createUser(new Student("Rohan", "anmoll@gmail.com", 19));

        //studentRepository.updateUser(new Student("ROhan", "Rohit@gmail.com", 23), 4L);

        //studentRepository.deleteUser(2L);

        //studentRepository.getUserById(5L);

        studentRepository.getAllUsers();


    }
}

// Url , username, password

// jdbc:mysql://localhost:3306/
