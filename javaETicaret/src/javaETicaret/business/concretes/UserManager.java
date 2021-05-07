package javaETicaret.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javaETicaret.business.abstracts.UserService;
import javaETicaret.core.UserVerificationService;
import javaETicaret.dataAccess.abstracts.UserDao;
import javaETicaret.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private UserVerificationService userVerificationService; 
	
	private ArrayList<String> emailList = new ArrayList<String>();
	private ArrayList<String> passwordList = new ArrayList<String>();
	
	public UserManager(UserDao userDao, UserVerificationService userVerificationService) {
		super();
		this.userDao = userDao;
		this.userVerificationService = userVerificationService;

	}
						

	
	
	@Override
	public void add(User user) {
		
		final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		 		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,
		Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());
		boolean result =matcher.matches();
		
		if(result==false) {
			System.out.println("Email should be in correct format");
			return;
		}
	
		
		if(user.getPassword().length() <= 6) {
			System.out.println("Password should be longer than 6 characters");
			return;
		}
		
		if(user.getName().length() <=2 && user.getSurName().length() <= 2) {
			System.out.println("Name and surname should be longer or equal to 2 characters");
			return;
		}
		
		if (emailList.contains(user.getEmail()) ) {
			System.out.println("This email adress is already used");
			return;
		}
						
		else {		
			if(userVerificationService.verify(user)==true) {
				this.userDao.add(user);
				this.emailList.add(user.getEmail());
				this.passwordList.add(user.getPassword());
				System.out.println("User is added to db");
			}
			else {
				System.out.println("User did not confirm his account");
			}
			
		}
		
}


	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void signIn(String email, String password) {
		
		if(emailList.contains(email) && passwordList.contains(password)) {
			System.out.println("Succesfully loged in");
		}
		else {
			System.out.println("Login is failed try again");
		}
		
	}

	
}
