package task1;

public class Students {

    private String sname;
    private String name;
    private int score;
    private String grade;

    Students(){};

    Students(String sname, String name, int score){
        this.sname = sname;
        this.name = name;
        this.score = score;
    }

    public String getSname(){
        return sname;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public String getGrade(){
        return grade;
    }

    public void setSname(String sname){
        this.sname = sname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }
}
