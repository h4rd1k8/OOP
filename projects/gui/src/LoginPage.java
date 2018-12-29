import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JLabel l1, l2, l3;
    private JTextField tf1;
    private JButton btn1;
    private JPasswordField p1;
    private String username;
    private String password;

    LoginPage() {
        JFrame frame = new JFrame("Login Form");
        l1 = new JLabel("Login Form");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Colibri", Font.BOLD, 20));

        l2 = new JLabel("Username");
        l3 = new JLabel("Password");
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Login");


        l1.setBounds(80, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);

        frame.add(l1);
        frame.add(l2);
        frame.add(tf1);
        frame.add(l3);
        frame.add(p1);
        frame.add(btn1);

        frame.setSize(600, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password1 = new String(p1.getPassword());
                if(tf1.getText().equals("admin") && password1.equals("pass")) {
                    JOptionPane.showMessageDialog(frame, "You logged as admin!");
                    TeacherPage tp1 = new TeacherPage();
                    tp1.setSize(800,500);
                    tp1.setVisible(true);
                    frame.setVisible(false);
                }else
                    JOptionPane.showMessageDialog(frame, "Access denied!");
            }
        });
    }

    public boolean equals(Object obj) {
        if (obj instanceof LoginPage) {
            LoginPage other = (LoginPage) obj;

            if (!username.equals(other.username)) return false;

            else if (!password.equals(this.password)) return false;

            else return true;

        } else return false;
    }

}
