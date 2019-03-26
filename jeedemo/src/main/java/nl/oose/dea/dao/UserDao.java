package nl.oose.dea.dao;

import nl.oose.dea.domain.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao implements IUserDao {

    @Resource(name = "jdbc/MySQLDB")
    private DataSource dataSource;

    @Override
    public String login(String userName, String password) {
        // Select * from user where user = .........
        return "dit token komt uit de database";
    }

    @Override
    public User getUser(int id) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE id = ?";

        try
        {
            Connection connection = dataSource.getConnection();


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            int count = 0;
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("fullName"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                count++;
            }
            if (count == 0){
                // no results
                return null;
            }

        }
        catch (SQLException e)
        {
            System.out.println("Error connecting to a database: " + e);
        }


        return user;
    }

    // Mainly used for testing
    public void setDataSource(DataSource ds){
        this.dataSource = ds;
    }
}
