package intranet.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Faculty;
	private String Specialization;
	private int YearOfStudy;
	private double GPA;
	private List<Course> RegisteredCourses;
	private List<Course> AllCourses;
	
	public Student(int iD, String firstName, String secondName, Date birthDate, String eMail, String login,
			String password, String faculty, String specialization, int yearOfStudy, double gPA) {
		super(iD, firstName, secondName, birthDate, eMail, login, password);
		Faculty = faculty;
		Specialization = specialization;
		YearOfStudy = yearOfStudy;
		GPA = gPA;
		RegisteredCourses = new ArrayList<>();
		AllCourses = new ArrayList<>();
		setType("Student");
		super.logging("Student Created");
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

	public int getYearOfStudy() {
		return YearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		YearOfStudy = yearOfStudy;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public List<Course> getRegisteredCourses() {
		return RegisteredCourses;
	}

	public void setRegisteredCourses(List<Course> registeredCourses) {
		RegisteredCourses = registeredCourses;
	}

	public List<Course> getAllCourses() {
		return AllCourses;
	}

	public void setAllCourses(List<Course> allCourses) {
		AllCourses = allCourses;
	}
	
	public void register(Course course) {
		RegisteredCourses.add(course);
		AllCourses.add(course);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Faculty == null) ? 0 : Faculty.hashCode());
		long temp;
		temp = Double.doubleToLongBits(GPA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Specialization == null) ? 0 : Specialization.hashCode());
		result = prime * result + YearOfStudy;
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
		Student other = (Student) obj;
		if (Faculty == null) {
			if (other.Faculty != null)
				return false;
		} else if (!Faculty.equals(other.Faculty))
			return false;
		if (Double.doubleToLongBits(GPA) != Double.doubleToLongBits(other.GPA))
			return false;
		if (Specialization == null) {
			if (other.Specialization != null)
				return false;
		} else if (!Specialization.equals(other.Specialization))
			return false;
		if (YearOfStudy != other.YearOfStudy)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [ID=" + getID() + ", FirstName=" + getFirstName() + ", SecondName=" + getSecondName() 
				+ ", BirthDate=" + getBirthDate() + ", Age=" + getAge() + ", EMail=" + getEMail() 
				+ ", Login=" + getLogin() + ", Password=" + getPassword() + ", Faculty=" + Faculty 
				+ ", Specialization=" + Specialization + ", YearOfStudy=" + YearOfStudy + ", GPA=" + GPA 
				+ ", RegisteredCourses=" + RegisteredCourses + ", AllCourses=" + AllCourses + "]";
	}
	
}
