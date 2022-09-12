import java.sql.*;

public class UserDao {
    private static final String ADD_USER = "INSERT INTO users" +
            "(username, firstname , lastname, profession, email, password)" +
            " VALUES (?,?,?,?,?,?)";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM users " +
            "WHERE username = ? and password = ?";
    private Connection connection;
    public UserDao(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",
                    "root", "1583");
        } catch (SQLException e) {
            e.printStackTrace();
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

        statement.executeQuery();
    }

    public User getUser(String password, String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD);
        statement.setString(1, username);
        statement.setString(2, password);
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
}
