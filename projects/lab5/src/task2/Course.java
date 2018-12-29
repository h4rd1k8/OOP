package task2;

public class Course {
    private String courseTitle;
    private Textbook textbook;
    private Instructor instructor;

    public Course(){};

    Course(String courseTitle, Textbook textbook, Instructor instructor){
        this.courseTitle = courseTitle;
        this.textbook = textbook;
        this.instructor = instructor;
    }

    public String getCourseTitle(){
        return courseTitle;
    }

    public Textbook getTextbook(){
        return textbook;
    }

    public Instructor getInstructor(){
        return instructor;
    }

    public void setCourseTitle(String courseTitle){
        this.courseTitle = courseTitle;
    }

    public void setTextbook(Textbook textbook){
        this.textbook = textbook;
    }

    public void setInstructor(Instructor instructor){
        this.instructor = instructor;
    }

    public String toString(){
        return "Course title: " + courseTitle + " Textbook: " + textbook + " Instructor: " + instructor;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course other = (Course) obj;

            if (!courseTitle.equals(other.courseTitle)) return false;

            else if (!textbook.equals(this.textbook)) return false;

            return instructor.equals(this.instructor);

        } else return false;
    }
}
