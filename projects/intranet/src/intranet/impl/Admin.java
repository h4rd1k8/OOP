package intranet.impl;

import java.io.File;

public class Admin extends Employee {
	private static final long serialVersionUID = 1L;

	public Admin(int iD, String firstName, String secondName, Date birthDate, String eMail, String login,
			String password) {
		super(iD, firstName, secondName, birthDate, eMail, login, password);
		setType("Admin");
		super.logging("Admin Created");
	}
	
	public void addUser(User user) {
		test.AllUsers.add(user);
	}
	
	public void removeUser(User user) {
		test.AllUsers.remove(user);
	}
	
	public void updateInfo(User tuser, User nuser) {
		tuser = nuser;
	}
	
	public File viewLogFile(User user) {
		return user.getLogFile();
	}

}
