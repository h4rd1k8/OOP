import javax.swing.*;

public class TeacherPage extends JFrame{

    private JTextField course_name;
    private JButton add_course;
    private JTextField speciality_of_course;
    private JPanel panel1;
    private JButton view_course;
    private JComboBox list_courses;
    private JLabel name_subject;
    private JLabel speciality_subject;
    private JLabel year_subject;
    private JButton del_course;
    private JComboBox list_del_course;

    public TeacherPage(){
        /*JFrame jframe = new JFrame("Teacher page");
        name_subject = new JLabel("Name of the subject: ");
        speciality_subject = new JLabel("Speciality: ");

        name_subject.setBounds(80,30,400,30);
        speciality_subject.setBounds(80,70,400,30);

        jframe.add(name_subject);
        jframe.add(speciality_subject);

        jframe.setLayout(null);
        jframe.setVisible(true);*/
        add(panel1);

    }

}
