package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.connectionDB();

    public UserDaoJDBCImpl() {

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

    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM Users WHERE id = ?";
        PreparedStatement prepared = connection.prepareStatement(sql);
        prepared.setLong(1, id);
        prepared.execute();
    }

    public List<User> getAllUsers() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT name, lastName, age FROM Users";
        ResultSet result = statement.executeQuery(sql);
        List<User> users = new ArrayList<>();
        while (result.next()) {
            String name = result.getString(1);
            String lastName = result.getString(2);
            byte age = result.getByte(3);
            users.add(new User(name, lastName, age));
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "TRUNCATE TABLE Users";
        statement.execute(sql);
    }
}
