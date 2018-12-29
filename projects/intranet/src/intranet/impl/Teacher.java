package intranet.impl;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee{
	private static final long serialVersionUID = 1L;
	private String Faculty;
	private String Specialization;
	private String Degree;
	private List<String> Messages;
	private List<Course> RegisteredCourses;
	
	public Teacher(int iD, String firstName, String secondName, Date birthDate, String eMail, String login,
			String password, String faculty, String specialization, String degree) {
		super(iD, firstName, secondName, birthDate, eMail, login, password);
		Faculty = faculty;
		Specialization = specialization;
		Degree = degree;
		RegisteredCourses = new ArrayList<>();
		Messages = new ArrayList<>();
		setType("Teacher");
		super.logging("Teacher Created");
	}

	public String getFaculty() {
		return Faculty;
	}

	public void setFaculty(String faculty) {
		Faculty = faculty;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public String getDegree() {
		return Degree;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}
	
	public void addCourse(Course course) {
		RegisteredCourses.add(course);
	}
	
	public List<Course> getRegisteredCourses() {
		return RegisteredCourses;
	}
	
	public List<User> viewStudents(Course course) {
		if (RegisteredCourses.contains(course)) {
			return course.getListOfStudents();
		}
		return null;
	}
	
	public void recieveMessage(String s) {
		Messages.add(s);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Degree == null) ? 0 : Degree.hashCode());
		result = prime * result + ((Faculty == null) ? 0 : Faculty.hashCode());
		result = prime * result + ((Specialization == null) ? 0 : Specialization.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (Degree == null) {
			if (other.Degree != null)
				return false;
		} else if (!Degree.equals(other.Degree))
			return false;
		if (Faculty == null) {
			if (other.Faculty != null)
				return false;
		} else if (!Faculty.equals(other.Faculty))
			return false;
		if (Specialization == null) {
			if (other.Specialization != null)
				return false;
		} else if (!Specialization.equals(other.Specialization))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [ID=" + getID() + ", FirstName=" + getFirstName() + ", SecondName=" + getSecondName() 
				+ ", BirthDate=" + getBirthDate() + ", Age=" + getAge() + ", EMail=" + getEMail() 
				+ ", Login=" + getLogin() + ", Password=" + getPassword() + ", Faculty=" + Faculty 
				+ ", Specialization=" + Specialization + ", Degree=" + Degree + ", RegisteredCourses=" + RegisteredCourses + "]";
	}

}
