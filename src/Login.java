package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back;

    Login() {
        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image first
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 600, 300);
        add(background);

        // Add components to background layer
        JLabel labelName = new JLabel("Username");
        labelName.setBounds(40, 20, 100, 20);
        background.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 20, 150, 20);
        background.add(textFieldName);

        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(40, 70, 100, 20);
        background.add(labelpass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        background.add(passwordField);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.red);
        login.addActionListener(this);
        background.add(login);

        back = new JButton("Back");
        back.setBounds(180, 140, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.red);
        back.addActionListener(this);
        background.add(back);

        // Optional logo image on right
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setBounds(350, 20, 200, 200);
        background.add(imgLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = textFieldName.getText();
            String password = passwordField.getText();

            String query = "select * from login where username='" + username + "' and password='" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new main_class(); // Make sure this class exists!
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false); // back button
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
