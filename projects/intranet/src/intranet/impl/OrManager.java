package intranet.impl;

import java.util.ArrayList;
import java.util.List;

public class OrManager extends Employee{
	private static final long serialVersionUID = 1L;

	public OrManager(int iD, String firstName, String secondName, Date birthDate, String eMail, String login,
			String password) {
		super(iD, firstName, secondName, birthDate, eMail, login, password);
		setType("OrManager");
		super.logging("OrManager Created");
	}
	
	public void createCourse(Integer courseId, String title, Integer requiredYear, String requiredSpecialization,
			Integer sectionNumber, User teacher) {
		test.AllCourses.add(new Course(courseId, title, requiredYear, requiredSpecialization, sectionNumber, teacher, null));
	}
	
	public List<User> viewTeachers() {
		List<User> temp = new ArrayList<>();
		for (int i = 0; i < test.AllUsers.size(); i++) {
			if (test.AllUsers.get(i).getType().equals("Teacher")) temp.add(test.AllUsers.get(i));
		}
		return temp;
	}
	
	public List<User> viewStudents() {
		List<User> temp = new ArrayList<>();
		for (int i = 0; i < test.AllUsers.size(); i++) {
			if (test.AllUsers.get(i).getType().equals("Student")) temp.add(test.AllUsers.get(i));
		}
		return temp;
	}
	
	public void senMessage(User user, String message) {
		user.recieveMessage(message);
	}

}
