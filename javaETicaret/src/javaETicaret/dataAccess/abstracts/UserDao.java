package javaETicaret.dataAccess.abstracts;

import java.util.List;

import javaETicaret.entities.concretes.User;

public interface UserDao {
	void add(User user);
	List<User> getAll();
}
