package javaETicaret;

import javaETicaret.business.abstracts.UserService;
import javaETicaret.business.concretes.UserManager;
import javaETicaret.core.UserVerificationManagerAdapter;
import javaETicaret.dataAccess.concretes.MemoryUserDao;
import javaETicaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new MemoryUserDao(), 
				new UserVerificationManagerAdapter());
		User user1 = new User(1, "Berkay", "Alic", "berkayalic@gmail.com", "10813517434");
		User user2 = new User(2, "Berkay", "Alic", "berkayalicgmail.com", "10813517434");
		User user3 = new User(3, "Berkay", "Alic", "berkayalic@gmail.com", "123");
		User user4 = new User(4, "B", "Ab", "berkayalic6@gmail.com", "123647134");
		User user5 = new User(5, "Badf", "Aadfb", "berkayalic@gmail.com", "1247134");
		userService.add(user1);
		userService.add(user2);
		userService.add(user3);
		userService.add(user4);
		userService.add(user5);
		
		userService.signIn("berkayalic@gmail.com", "10813517434");
	}

}
