package javaETicaret.core;

import javaETicaret.entities.concretes.User;

public interface UserVerificationService {
	boolean verify(User user);
}
