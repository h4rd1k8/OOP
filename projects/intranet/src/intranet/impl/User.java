package intranet.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int ID;
	private String FirstName;
	private String SecondName;
	private Date BirthDate;
	private String EMail;
	private String Login;
	private String Password;
	private File LogFile;
	private String Type;

	public User(int iD, String firstName, String secondName, Date birthDate, String eMail, String login,
			String password) {
		ID = iD;
		FirstName = firstName;
		SecondName = secondName;
		BirthDate = birthDate;
		EMail = eMail;
		Login = login;
		Password = password;
		String fileName = "ID_"+ ID + "_" + FirstName + SecondName + ".txt";
		LogFile = new File(fileName);
	}

	public File getLogFile() {
		return LogFile;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getSecondName() {
		return SecondName;
	}

	public void setSecondName(String secondName) {
		SecondName = secondName;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	
	public int getAge() {
		int y = BirthDate.getYear();
		int m = BirthDate.getMonth();
		int d = BirthDate.getDay();
		y = Calendar.getInstance().get(Calendar.YEAR) - y;
		m = Calendar.getInstance().get(Calendar.MONTH) - m + 1;
		d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - d;
		if (m >= 0 && d >= 0) return y; else return y - 1;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public String getFaculty() {
		return null;
	}

	public void setFaculty(String faculty) {
	}

	public String getSpecialization() {
		return null;
	}

	public void setSpecialization(String specialization) {
	}

	public int getYearOfStudy() {
		return -1;
	}

	public void setYearOfStudy(int yearOfStudy) {
	}

	public double getGPA() {
		return -1;
	}

	public void setGPA(double gPA) {
	}

	public List<Course> getRegisteredCourses() {
		return null;
	}

	public void setRegisteredCourses(List<Course> registeredCourses) {
	}

	public List<Course> getAllCourses() {
		return null;
	}

	public void setAllCourses(List<Course> allCourses) {
	}

	public String getDegree() {
		return null;
	}

	public void setDegree(String degree) {
	}
	
	public void addCourse(Course course) {
	}
	
	public void recieveMessage(String s) {
	}
	
	public void reciveOrder(Order order) {
	}
	
	public List<Order> viewOrders() {
		return null;
	}
	
	public void sendOrder(TechSupportGuy tsg, Order order) {
	}
	
	public void logging(String event) {
		try {
			if (!LogFile.exists()) {
				System.out.println("Creating log file...\n");
				LogFile.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(LogFile, true));
			String timeStamp = new SimpleDateFormat("dd:MM:yyyy | HH:mm:ss").format(Calendar.getInstance().getTime());
			out.println(timeStamp.toString() + "    " + event);
			out.close();
		} catch (IOException e) {
			System.out.println("LOGGING ERROR!!!");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BirthDate == null) ? 0 : BirthDate.hashCode());
		result = prime * result + ((EMail == null) ? 0 : EMail.hashCode());
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Login == null) ? 0 : Login.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((SecondName == null) ? 0 : SecondName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (BirthDate == null) {
			if (other.BirthDate != null)
				return false;
		} else if (!BirthDate.equals(other.BirthDate))
			return false;
		if (EMail == null) {
			if (other.EMail != null)
				return false;
		} else if (!EMail.equals(other.EMail))
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (ID != other.ID)
			return false;
		if (Login == null) {
			if (other.Login != null)
				return false;
		} else if (!Login.equals(other.Login))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (SecondName == null) {
			if (other.SecondName != null)
				return false;
		} else if (!SecondName.equals(other.SecondName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [ID=" + ID + ", FirstName=" + FirstName + ", SecondName=" + SecondName + ", BirthDate=" + BirthDate
				+ ", EMail=" + EMail + ", Login=" + Login + ", Password=" + Password + "]";
	}

	public void addUser(User user) {
		
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	public void register(Course course) {
		
	}
	
	public List<User> viewStudents() {
		return null;
	}
	
	public List<User> viewTeachers() {
		return null;
	}
	
	public void createCourse(Integer courseId, String title, Integer requiredYear, String requiredSpecialization,
			Integer sectionNumber, User teacher) {
	}
	
}
