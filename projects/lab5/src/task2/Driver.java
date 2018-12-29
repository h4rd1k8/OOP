package task2;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Driver {
    private Mode current;
    private String adminName = "e_alipbaev";
    private String password = "kbtu1111";
    private ArrayList<Textbook> textbooks;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;

    private final Scanner SCAN = new Scanner(System.in);

    private final String PATH = "/home/yerdaulet/projects/lab5/src/admin.txt";

    private final String I_EXCEPT = "Cannot read from file";
    private final String O_EXCEPT = "Cannot write to file";
    private final String FILE_EXCEPT = "Cannot open the file";
    private final String CLASS_EXCEPT = "Cannot find the class";
    private final String ACCESS_DENY = "Access denied!";
    private final String EXIST = "Object already exists!";
    private final String WRONG_DATA = "Wrong input data!";


    private final String DATE_PATTERN = "dd.MM.yy HH:mm";

    private final String LOG_IN = "logged in to a system";
    private final String BEGIN = "Are you log in as user or admin?";

    {
        current = Mode.init;
        textbooks = new ArrayList<>();
        instructors = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public Driver() {
        loadData();
    }

    public void begin() {
        System.out.println(BEGIN);

        String line = SCAN.nextLine().toLowerCase();

        if (line.equals("user")) current = Mode.user;

        else if (line.equals("admin")) current = Mode.admin;

        switch (current) {
            case user:
                user();
                break;
            case admin:
                admin();
                break;
        }
    }

    private void user() {
        System.out.println("You entered as user");

        int i = 1;

        for (Course c: courses) {
            System.out.println(i + ". " + c.getCourseTitle());

            i++;
        }

        while (true) {
            System.out.println("Do you want to info about any course?");
            String line = SCAN.nextLine().toLowerCase();

            if (line.equals("exit")) {
                return;
            }
            else {
                int ind = Integer.decode(line);

                if (ind > courses.size()) {
                    System.out.println("Non valid course!");
                }
                else {
                    printInfo(courses.get(ind-1));
                }
            }
        }

    }

    private void admin() {
        System.out.println("You entered as admin");
        System.out.println("Enter your user name and password!");

        String user = SCAN.nextLine();
        String pass = SCAN.nextLine();

        loadPassword();

        if (user.equals(adminName) && pass.equals(password)) {

            writeStory(LOG_IN);

            System.out.println("Do you want to create textbook, instructor, course or may be exit?");

            while (true){
                String line = SCAN.nextLine().toLowerCase();

                switch (line) {
                    case "exit":
                        System.out.println("Seance ended!");
                        return;
                    case "textbook":
                        createTextbook();
                        break;
                    case "instructor":
                        createInstructor();
                        break;
                    case "course":
                        createCourse();
                        break;
                    default:
                        System.out.println("Enter command again!");
                        break;
                }
            }

        }
        else {
            System.out.println(ACCESS_DENY);
            current = Mode.init;
        }
    }

    private void createTextbook() {
        System.out.println("Enter book`s ISBN:");
        String isbn = SCAN.nextLine();

        System.out.println("Enter book`s title:");
        String title = SCAN.nextLine();

        System.out.println("Enter book`s author:");
        String author = SCAN.nextLine();

        Textbook textbook;

        try {
            textbook = new Textbook(isbn, title, author);
        }
        catch (Exception e) {
            System.out.println("Wrong input data!");
            return;
        }

        writeStory(String.format("added new textbook \"%s\"", title));

        if (textbooks.contains(textbook)) {
            System.out.println(EXIST);
        }
        else {
            textbooks.add(textbook);

            try {
                ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("textbooks.out"));

                oot.writeObject(textbooks);

                oot.flush();
                oot.close();

                System.out.println("Success");
            }
            catch (FileNotFoundException e) {
                System.out.println(FILE_EXCEPT);
            }
            catch (IOException e) {
                System.out.println(O_EXCEPT);
            }
        }
    }

    private void createInstructor() {
        System.out.println("Enter instructor`s first name:");
        String fname = SCAN.nextLine();

        System.out.println("Enter instructor`s last name:");
        String lname = SCAN.nextLine();

        System.out.println("Enter instructor`s department:");
        String department = SCAN.nextLine();

        System.out.println("Enter instructor`s e-mail:");
        String email = SCAN.nextLine();

        Instructor instructor;

        try {
            instructor = new Instructor(fname, lname, department, email);
        }
        catch (Exception e) {
            System.out.println(WRONG_DATA);
            return;
        }

        if (instructors.contains(instructor)) {
            System.out.println(EXIST);
        }
        else {
            writeStory(String.format("added new instructor %s %s", fname, lname));

            instructors.add(instructor);

            try {
                ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("instructors.out"));

                oot.writeObject(instructors);

                oot.flush();
                oot.close();

                System.out.println("Success");
            }
            catch (FileNotFoundException e) {
                System.out.println(FILE_EXCEPT);
            }
            catch (IOException e) {
                System.out.println(O_EXCEPT);
            }
        }
    }

    private void createCourse() {
        System.out.println("Enter course`s name:");
        String courseName = SCAN.nextLine();

        System.out.println("Enter textbook`s isbn:");
        String isbn = SCAN.nextLine();

        System.out.println("Enter instructor`s e-mail:");
        String email = SCAN.nextLine();

        Course course;
        Textbook textbook = null;
        Instructor instructor = null;

        for (Textbook t: textbooks) {
            if (t.getIsbn().equals(isbn)) {
                textbook = t;
                break;
            }
        }

        for (Instructor i: instructors) {
            if (i.getEmail().equals(email)) {
                instructor = i;
                break;
            }
        }

        if (textbook == null || instructor == null) {
            System.out.println("Cannot find existing instructor or textbook");
        }
        else {
            course = new Course(courseName, textbook, instructor);

            writeStory(String.format("added new course \"%s\"", courseName));

            if (courses.contains(course)) {
                System.out.println(EXIST);
            }
            else {
                courses.add(course);

                try {
                    ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("courses.out"));

                    oot.writeObject(courses);

                    oot.flush();
                    oot.close();

                    System.out.println("Success");
                }
                catch (FileNotFoundException e) {
                    System.out.println(FILE_EXCEPT);
                }
                catch (IOException e) {
                    System.out.println(O_EXCEPT);
                }
            }
        }


    }

    private void printInfo(Course c) {
        Instructor i = c.getInstructor();
        Textbook t = c.getTextbook();

        System.out.println(String.format("Course name: %s", c.getCourseTitle()));
        System.out.println(String.format("Course instructor`s name: %s %s, department: %s, e-mail: %s",
                i.getFirstName(), i.getLastName(), i.getDepartment(), i.getEmail()));
        System.out.println(String.format("Course textbook`s title: %s, author: %s, isbn: %s",
                t.getTitle(), t.getAuthor(), t.getIsbn()));
    }

    private void writeStory(String message) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);

            bw.write(dtf.format(LocalDateTime.now()) + " Admin " + message + "\n");

            bw.close();
        }
        catch (IOException e) {
            System.out.println(O_EXCEPT);
        }
    }

    private void loadData() {
        loadPassword();
        loadTextbooks();
        loadInstructors();
        loadCourses();
    }

    private void loadTextbooks() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("textbooks.out"));

            textbooks = (ArrayList<Textbook>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println(FILE_EXCEPT);
        }
        catch (IOException e) {
            System.out.println(I_EXCEPT);
        }
        catch (ClassNotFoundException e) {
            System.out.println(CLASS_EXCEPT);
        }
    }

    private void loadInstructors() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("instructors.out"));

            Object obj = ois.readObject();

            instructors = (ArrayList<Instructor>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println(FILE_EXCEPT);
        }
        catch (IOException e) {
            System.out.println(I_EXCEPT);
        }
        catch (ClassNotFoundException e) {
            System.out.println(CLASS_EXCEPT);
        }
    }

    private void loadCourses() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("courses.out"));

            courses = (ArrayList<Course>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println(FILE_EXCEPT);
        }
        catch (IOException e) {
            System.out.println(I_EXCEPT);
        }
        catch (ClassNotFoundException e) {
            System.out.println(CLASS_EXCEPT);
        }
    }

    private void loadPassword() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH));

            String first = br.readLine();
            String second = br.readLine();

            adminName = first.split(" ")[1];
            password = second.split(" ")[1];

            br.close();
        }
        catch (FileNotFoundException fe) {
            System.out.println(FILE_EXCEPT);
        }
        catch (IOException ioe) {
            System.out.println(I_EXCEPT);
        }
    }
}
