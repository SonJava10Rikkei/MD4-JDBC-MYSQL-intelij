package rikkei.academy.service;

import rikkei.academy.config.ConnectMySQL;
import rikkei.academy.model.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {
    private static final String CREATE_STUDENT = "insert into student(name, age) VALUES (?,?);";
    private Connection connection = ConnectMySQL.getConnection();

    @Override
    public List<Students> findAll() {
        return null;
    }

    @Override
    public void save(Students students) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT);
            preparedStatement.setString(1, students.getName());
            preparedStatement.setInt(2, students.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Students findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
