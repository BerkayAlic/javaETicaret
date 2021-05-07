package javaETicaret.core;

import javaETicaret.entities.concretes.User;
public class UserVerificationManagerAdapter implements UserVerificationService{
	

	@Override
	public boolean verify(User user) {
		System.out.println("Please confirm your account");
		return true;		
		}
	
}
