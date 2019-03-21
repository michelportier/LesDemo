package nl.oose.dea.dao;

import nl.oose.dea.domain.User;

public interface IUserDao {
    public String login(String userName, String password);
    public User getUser(int id);
}
