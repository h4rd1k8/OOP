package intranet.impl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	
	public static List<Course> AllCourses;
	public static List<User> AllUsers;
	static Scanner in;
	static User CUser;

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		User st1 = new Admin(1, "Alisher", "Uteshev", new Date(25, 06, 1995), "alisher.uteshev@gmail.com", "Savage", "LiL");
		System.out.println(st1);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"));
		oos.writeObject(st1);
		oos.flush();
		oos.close();
		
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("temp.out"));
		User stt = (Admin) oin.readObject();
		oin.close();
		System.out.println(stt);
		
		driver();
		in = new Scanner(System.in);
	}
	
	public static void driver() {
		AllCourses = new ArrayList<>();
		AllUsers = new ArrayList<>();
		
		in = new Scanner(System.in);
		boolean flag = false;
		while (!flag) {
			int instr = 0;
			System.out.println("Login Page");
			System.out.println("------------------------");
			System.out.println("In order to login enter:");
			System.out.println("1 as Admin");
			System.out.println("2 as Teacher");
			System.out.println("3 as Student");
			System.out.println("4 as OrManager");
			System.out.println("5 as TechSupportGuy");
			System.out.println("------------------------");
			System.out.println("Enter 9 to Exit ");
			instr = in.nextInt();
			
			switch (instr) {
				case (1) : {
					check("Admin");
					adminPage();
					break;
				}
				case (2) : {
					check("Teacher");
					teacherPage();
					break;
				}
				case (3) : {
					check("Student");
					studentPage();
					break;
				}
				case (4) : {
					check("OrManager");
					orManagerPage();
					break;
				}
				case (5) : {
					check("TechSupport");
					//techPage();
					break;
				}
				case (9) : {
					flag = true;
					break;
				}
			}
			
		}
		
	}
	
	public static void check(String s) {
		System.out.println("------------------------");
		System.out.print("Login: ");
		String login = in.nextLine();
		System.out.print("Password: ");
		String password = in.nextLine();
		System.out.println("------------------------");
		CUser = null;
		for (int i = 0; i < AllUsers.size(); i++) {
			if (AllUsers.get(i).getLogin().equals(login) && AllUsers.get(i).getPassword().equals(password) && AllUsers.get(i).getType().equals(s)) {
				CUser = AllUsers.get(i);
			}
		}
	}
	
	public static void adminPage() {
		boolean flag = false;
		while (!flag) {
			int instr = 0;
			System.out.println("Admin Page");
			System.out.println("------------------------");
			System.out.println("Menu:");
			System.out.println("1 add User");
			System.out.println("2 remove User");
			System.out.println("3 update info about User");
			System.out.println("4 view log file");
			System.out.println("------------------------");
			System.out.println("Enter 9 to go Back ");
			instr = in.nextInt();
			switch (instr) {
				case (1) : {
					selectUserType();
					break;
				}
				case (2) : {
					deleteUser();
					break;
				}
				case (3) : {
					//updateInfo();
					break;
				}
				case (4) : {
					//viewLog();
					break;
				}
				case (9) : {
					flag = true;
					break;
				}
			}
		}
	}
	
	public static void selectUserType() {
		boolean flag = false;
		while (!flag) {
			int instr = 0;
			System.out.println("User Create Menu");
			System.out.println("------------------------");
			System.out.println("Menu:");
			System.out.println("1 create Admin");
			System.out.println("2 create Teacher");
			System.out.println("3 create Student");
			System.out.println("4 create OrManager");
			System.out.println("5 create TechSupport");
			System.out.println("------------------------");
			System.out.println("Enter 9 to go Back ");
			instr = in.nextInt();
			switch (instr) {
				case (1) : {
					inputForm(1);
					break;
				}
				case (2) : {
					inputForm(2);
					break;
				}
				case (3) : {
					inputForm(3);
					break;
				}
				case (4) : {
					inputForm(4);
					break;
				}
				case (5) : {
					inputForm(5);
					break;
				}
				case (9) : {
					flag = true;
					break;
				}
			}
		}
	}
	
	public static void inputForm(int x) {
		
		System.out.print("ID: ");
		int iD = in.nextInt();
		System.out.print("Firstname: ");
		String firstName = in.nextLine();
		System.out.print("SecondName: ");
		String secondName = in.nextLine();
		System.out.print("BirthDate: ");
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		Date birthDate = new Date(a, b, c);
		System.out.print("EMail: ");
		String eMail = in.nextLine();
		System.out.print("Login: ");
		String login = in.nextLine();
		System.out.print("Password: ");
		String password = in.nextLine();
		
		if (x == 1) {
			User user = new Admin(iD, firstName, secondName, birthDate, eMail, login, password);
			CUser.addUser(user);
		}
		
		if (x == 2) {
			System.out.print("Faculty: ");
			String f = in.nextLine();
			System.out.print("Specialization: ");
			String s = in.nextLine();
			System.out.print("Degree: ");
			String d = in.nextLine();
			User user = new Teacher(iD, firstName, secondName, birthDate, eMail, login, password, f, s, d);
			CUser.addUser(user);
		}
		if (x == 3) {
			System.out.print("Faculty: ");
			String f = in.nextLine();
			System.out.print("Specialization: ");
			String s = in.nextLine();
			System.out.print("YearOfStudy: ");
			int y = in.nextInt();
			System.out.print("GPA: ");
			double g = in.nextDouble();
			User user = new Student(iD, firstName, secondName, birthDate, eMail, login, password, f, s, y, g);
			CUser.addUser(user);
		}
		if (x == 4) {
			User user = new OrManager(iD, firstName, secondName, birthDate, eMail, login, password);
			CUser.addUser(user);
		}
		if (x == 5) {
			User user = new TechSupportGuy(iD, firstName, secondName, birthDate, eMail, login, password);
			CUser.addUser(user);
		}
		
	}
	
	public static void deleteUser() {
		boolean flag = false;
		while (!flag) {
			int instr = 0;
			System.out.println("User delete Menu");
			System.out.println("------------------------");
			System.out.println("Menu:");
			System.out.println("1 delete Admin");
			System.out.println("2 delete Teacher");
			System.out.println("3 delete Student");
			System.out.println("4 delete OrManager");
			System.out.println("5 delete TechSupport");
			System.out.println("------------------------");
			System.out.println("Enter 9 to go Back ");
			instr = in.nextInt();
			switch (instr) {
				case (1) : {
					printAllandRemove("Admin");
					break;
				}
				case (2) : {
					printAllandRemove("Teacher");
					break;
				}
				case (3) : {
					printAllandRemove("Student");
					break;
				}
				case (4) : {
					printAllandRemove("OrManager");
					break;
				}
				case (5) : {
					printAllandRemove("TechSupport");
					break;
				}
				case (9) : {
					flag = true;
					break;
				}
			}
		}
	}
	
	public static void printAllandRemove(String s) {
		List<User> temp = new ArrayList<>();
		for (int i = 0; i < test.AllUsers.size(); i++) {
			User tuser = AllUsers.get(i);
			if (tuser.getType().equals(s)) {
				temp.add(tuser);
				System.out.println(i + 1 + ": " + tuser.getLogin());
			}
		}
		System.out.print("Which user to delete: ");
		int x = in.nextInt();
		if (x <= temp.size()) {
			int p = AllUsers.indexOf(temp.get(x - 1));
			AllUsers.remove(p);
		}
	}
	
	public static void teacherPage() {
		boolean flag = false;
		while (!flag) {
			int instr = 0;
			System.out.println("Teacher Page");
			System.out.println("------------------------");
			System.out.println("Menu:");
			System.out.println("1 add Course");
			System.out.println("2 view registered Courses");
			System.out.println("3 add Course File");
			System.out.println("4 delete Course File");
			System.out.println("5 view Students");
			System.out.println("6 put Mark");
			System.out.println("------------------------");
			System.out.println("Enter 9 to go Back ");
			instr = in.nextInt();
			switch (instr) {
				case (1) : {
					printAllCourses();
					int x = in.nextInt();
					if (x <= AllCourses.size()) {
						CUser.addCourse(AllCourses.get(x - 1));
					}
					break;
				}
				case (2) : {
					List<Course> temp = CUser.getRegisteredCourses();
					for (int i = 0; i < temp.size(); i++) {
						System.out.println(temp.get(i).getTitle());
					}
					break;
				}
				case (3) : {
					//addCourseFile();
					break;
				}
				case (4) : {
					//deleteFile();
					break;
				}
				case (5) : {
					viewStudents();
					break;
				}
				case (6) : {
					//deleteFile();
					break;
				}
				case (9) : {
					flag = true;
					break;
				}
			}
		}
	}
	
	public static void printAllCourses() {
		for (int i = 0; i < AllCourses.size(); i++) {
			System.out.println((i + 1) + ": " + AllCourses.get(i).getTitle());
		}
	}
	
	public static void viewStudents() {
		printAllCourses();
		int x = in.nextInt();
		List<Course> temp = CUser.getRegisteredCourses();
		if (x <= temp.size()) {
			List<User> ls = temp.get(x - 1).getListOfStudents();
			for (int i = 0; i < ls.size(); i++)
				System.out.println(ls.get(i).getID() + " " + ls.get(i).getFirstName() + " " + ls.get(i).getSecondName());
		}
	}
	
	public static void studentPage() {
		boolean flag = false;
		while (!flag) {
			int instr = 0;
			System.out.println("Student Page");
			System.out.println("------------------------");
			System.out.println("Menu:");
			System.out.println("1 register for a Course");
			System.out.println("2 view registered Courses");
			System.out.println("3 view Course File");
			System.out.println("4 info about Course");
			System.out.println("5 view Marks");
			System.out.println("6 view Transcript");
			System.out.println("------------------------");
			System.out.println("Enter 9 to go Back ");
			instr = in.nextInt();
			switch (instr) {
				case (1) : {
					printAllCourses();
					int x = in.nextInt();
					if (x <= AllCourses.size()) {
						CUser.register(AllCourses.get(x - 1));
					}
					break;
				}
				case (2) : {
					List<Course> temp = CUser.getRegisteredCourses();
					for (int i = 0; i < temp.size(); i++) {
						System.out.println(temp.get(i).getTitle());
					}
					break;
				}
				case (3) : {
					//viewCourseFile();
					break;
				}
				case (4) : {
					//viewInfo();
					break;
				}
				case (5) : {
					viewMarks();
					break;
				}
				case (6) : {
					//viewTrancript();
					break;
				}
				case (9) : {
					flag = true;
					break;
				}
			}
		}
	}
	
	public static void viewMarks() {
		List<Course> lc = CUser.getRegisteredCourses();
		for (int i = 0; i < lc.size(); i++) {
			Course temp = lc.get(i);
			System.out.println(temp.getTitle());
			Mark m = temp.getMarksByStudent(CUser);
			System.out.println(m);
		}
	}
	
	public static void orManagerPage() {
		boolean flag = false;
		while (!flag) {
			int instr = 0;
			System.out.println("Student Page");
			System.out.println("------------------------");
			System.out.println("Menu:");
			System.out.println("1 create Course");
			System.out.println("2 view Teachers");
			System.out.println("3 view Students");
			System.out.println("4 send Message");
			System.out.println("------------------------");
			System.out.println("Enter 9 to go Back ");
			instr = in.nextInt();
			switch (instr) {
				case (1) : {
					createCourse();
					break;
				}
				case (2) : {
					List<User> temp = CUser.viewTeachers();
					for (int i = 0; i < temp.size(); i++) {
						System.out.println(temp.get(i));
					}
					break;
				}
				case (3) : {
					List<User> temp = CUser.viewStudents();
					for (int i = 0; i < temp.size(); i++) {
						System.out.println(temp.get(i));
					}
					break;
				}
				case (4) : {
					//sendMessage();
					break;
				}
				case (9) : {
					flag = true;
					break;
				}
			}
		}
	}
	
	public static void createCourse() {
		System.out.print("Course ID: ");
		int courseId = in.nextInt();
		System.out.print("Title: ");
		String title = in.nextLine();
		System.out.print("requiredYear: ");
		int requiredYear = in.nextInt();
		System.out.print("requiredSpecialization: ");
		String requiredSpecialization = in.nextLine();
		System.out.print("Section Number: ");
		int sectionNumber = in.nextInt();
		System.out.print("Teacher: ");
		PrintAllTeachers();
		int t = in.nextInt();
		User teacher = AllUsers.get(t);
		CUser.createCourse(courseId, title, requiredYear, requiredSpecialization, sectionNumber, teacher);
	}
	
	public static void PrintAllTeachers() {
		for (int i = 0; i < AllUsers.size(); i++) {
			System.out.println((i + 1) + ": " + AllUsers.get(i).getFirstName() + " " + AllUsers.get(i).getSecondName());
			
		}
	}
	

}
