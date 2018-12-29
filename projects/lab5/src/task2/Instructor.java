package task2;

public class Instructor {
    private String firstName;
    private String lastName;
    private String department;
    private String email;

    public Instructor(){};

    Instructor(String firstname, String lastName, String department, String email){
        this.firstName = firstname;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getDepartment(){
        return department;
    }

    public String getEmail(){
        return email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String toString(){
        return "First name: " + firstName + " " + "Last name: " + lastName + " " + "Department: " + department + " " + "Email: " + email;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Instructor) {
            Instructor other = (Instructor) obj;

            if (!lastName.equals(other.lastName)) return false;

            else if (!firstName.equals(other.firstName)) return false;

            else if (!department.equals(other.department)) return false;

            else if (!email.equals(other.email)) return false;

            else return true;
        }
        else return false;
    }
}
