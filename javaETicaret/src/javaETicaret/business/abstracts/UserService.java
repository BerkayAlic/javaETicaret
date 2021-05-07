package javaETicaret.business.abstracts;

import java.util.List;

import javaETicaret.entities.concretes.User;

public interface UserService {
	void add(User user);
	void signIn(String email, String password);
	List<User> getAll();
}
