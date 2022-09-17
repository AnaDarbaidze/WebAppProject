package com.example.webapp;

import java.sql.*;

public class UserDao {
    private static final String ADD_USER = "INSERT INTO users" +
            "(username, firstname , lastname, profession, email, password)" +
            " VALUES (?,?,?,?,?,?)";

    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users u " +
            "WHERE username = ?";

    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM users u " +
            "WHERE email = ?";

    private static final String UPDATE_USER_DATA = "update users " +
            "set username = ?, firstname = ?, lastname = ?, profession = ?, email = ?, password = ?" +
            "where id = ?";

    private Connection connection;
    public UserDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",
                    "root", "1583");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeConnection() {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(ADD_USER);

        statement.setString(1,user.getUsername());
        statement.setString(2,user.getFirstname());
        statement.setString(3,user.getLastname());
        statement.setString(4,user.getProfession());
        statement.setString(5,user.getEmail());
        statement.setString(6,user.getPassword());

        statement.executeUpdate();
    }

    public User getUserByEmail(String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_EMAIL);
        statement.setString(1, email);
        return executeQuery(statement);
    }

    public User getUser(String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_USERNAME);
        statement.setString(1, username);
        return executeQuery(statement);
    }

    private User executeQuery(PreparedStatement statement) throws SQLException {
        ResultSet rs = statement.executeQuery();
        if (!rs.next()){
            return null;
        }
        User user = new User(rs.getInt("id"),
                rs.getString("username"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("profession"),
                rs.getString("password"),
                rs.getString("email")
        );
        return user;
    }

    public void updateUserData(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_USER_DATA);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getFirstname());
        statement.setString(3, user.getLastname());
        statement.setString(4, user.getProfession());
        statement.setString(5, user.getPassword());
        statement.setString(6, user.getEmail());
        statement.setInt(7, user.getId());
        statement.executeUpdate();

    }
}
