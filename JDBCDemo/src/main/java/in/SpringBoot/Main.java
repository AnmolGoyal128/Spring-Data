package in.SpringBoot;

import in.SpringBoot.Repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {
        System.out.println("Hello World");

        StudentRepository studentRepository = new StudentRepository();

        //studentRepository.createUser();

        //studentRepository.updateUser();

        //studentRepository.deleteUser();

        studentRepository.getUserById();


    }
}

// Url , username, password

// jdbc:mysql://localhost:3306/
