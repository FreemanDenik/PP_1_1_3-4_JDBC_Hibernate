package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;
public class UserServiceImpl implements UserService {
    Connection connection;
    public UserServiceImpl(){
        this.connection = Util.connectionDB();
    }
    public UserServiceImpl(Connection connection) {
        this.connection = connection;
    }
    public void createUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = """
                CREATE TABLE IF NOT EXISTS Users
                (
                    id BIGINT NOT NULL AUTO_INCREMENT,
                    name VARCHAR(255),
                    lastName VARCHAR(255),
                    age TINYINT,
                    PRIMARY KEY (`id`)
                )
                """;
        statement.execute(sql);
    }

    public void dropUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "DROP TABLE IF EXISTS Users";
        statement.execute(sql);
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = "INSERT INTO Users (name, lastName, age) VALUES(?,?,?)";
        PreparedStatement prepared = connection.prepareStatement(sql);
        prepared.setString(1, name);
        prepared.setString(2, lastName);
        prepared.setByte(3, age);
        prepared.execute();
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
