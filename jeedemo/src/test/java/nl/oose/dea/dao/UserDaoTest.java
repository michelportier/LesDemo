package nl.oose.dea.dao;

import nl.oose.dea.domain.User;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserDaoTest {

    @Test
    public void getUserTest(){
        try {
            DataSource dataSource = mock(DataSource.class);
            Connection connection = mock(Connection.class);
            PreparedStatement preparedStatement = mock(PreparedStatement.class);
            ResultSet resultSet = mock(ResultSet.class);
            String expectedSQL = "SELECT * FROM user WHERE id = ?";

            when(dataSource.getConnection()).thenReturn(connection);
            when(connection.prepareStatement(expectedSQL)).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(false);


            UserDao userDao = new UserDao();
            userDao.setDataSource(dataSource);

            int userId = 25;

            // This is the point where the real test happens:
            User user = userDao.getUser(userId);

            verify(dataSource).getConnection();
            verify(connection).prepareStatement(expectedSQL);
            verify(preparedStatement).setInt(1,userId);
            verify(preparedStatement).executeQuery();



            assertNull(user);

        }
        catch (SQLException e){
            fail();
        }
    }
}
