package in.mtr.service;

import java.util.List;

import in.mtr.entity.User;

public interface IUserService {
public abstract int registerUser(User user);
public abstract List<User> getUsers();
public abstract User getUser(int id);
public abstract void deleteUser(Integer id);
}
