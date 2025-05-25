package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateStudent extends JFrame implements ActionListener {

    JTextField textName, textfather, empText, dobdob, textM10, textM12;
    JTextField textAddress, textPhone, textemail, textAadhar, textcourse, textbranch;
    JButton submit, cancel;
    Choice cEMPID;

    public updateStudent() {
        getContentPane().setBackground(new Color(230, 210, 252));
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel empID = new JLabel("Select Roll Number");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250, 100, 200, 20);
        add(cEMPID);

        // Load roll numbers into Choice
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT rollno FROM student");
            while (rs.next()) {
                cEMPID.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Labels and TextFields
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        textfather = new JTextField();
        textfather.setBounds(600, 150, 150, 30);
        add(textfather);

        JLabel rollnoLabel = new JLabel("Roll Number");
        rollnoLabel.setBounds(50, 200, 200, 30);
        rollnoLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(rollnoLabel);

        empText = new JTextField();
        empText.setBounds(200, 200, 150, 30);
        empText.setEditable(false);
        add(empText);

        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(400, 200, 200, 30);
        dobLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(dobLabel);

        dobdob = new JTextField();
        dobdob.setBounds(600, 200, 150, 30);
        add(dobdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 300, 150, 30);
        add(textemail);

        JLabel m10Label = new JLabel("Class X (%)");
        m10Label.setBounds(400, 300, 200, 30);
        m10Label.setFont(new Font("serif", Font.BOLD, 20));
        add(m10Label);

        textM10 = new JTextField();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        JLabel m12Label = new JLabel("Class XII (%)");
        m12Label.setBounds(50, 350, 200, 30);
        m12Label.setFont(new Font("serif", Font.BOLD, 20));
        add(m12Label);

        textM12 = new JTextField();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        JLabel aadharLabel = new JLabel("Aadhar Number");
        aadharLabel.setBounds(400, 350, 200, 30);
        aadharLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(aadharLabel);

        textAadhar = new JTextField();
        textAadhar.setBounds(600, 350, 150, 30);
        add(textAadhar);

        JLabel courseLabel = new JLabel("Course");
        courseLabel.setBounds(50, 400, 200, 30);
        courseLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(courseLabel);

        textcourse = new JTextField();
        textcourse.setBounds(200, 400, 150, 30);
        add(textcourse);

        JLabel branchLabel = new JLabel("Branch");
        branchLabel.setBounds(400, 400, 200, 30);
        branchLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(branchLabel);

        textbranch = new JTextField();
        textbranch.setBounds(600, 400, 150, 30);
        add(textbranch);

        // Load data for the initially selected student
        loadStudentDetails();

        // Add listener for roll number changes
        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadStudentDetails();
            }
        });

        // Buttons
        submit = new JButton("Update");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.red);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        setVisible(true);
    }

    private void loadStudentDetails() {
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student WHERE rollno = '" + cEMPID.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textfather.setText(resultSet.getString("fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_x"));
                textM12.setText(resultSet.getString("class_xii"));
                textAadhar.setText(resultSet.getString("aadhar"));
                empText.setText(resultSet.getString("rollno"));
                textcourse.setText(resultSet.getString("course"));
                textbranch.setText(resultSet.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                Conn c = new Conn();
                String updateQuery = "UPDATE student SET name=?, fname=?, dob=?, class_x=?, class_xii=?, address=?, phone=?, email=?, aadhar=?, course=?, branch=? WHERE rollno=?";
                PreparedStatement pst = c.connection.prepareStatement(updateQuery);

                pst.setString(1, textName.getText());
                pst.setString(2, textfather.getText());
                pst.setString(3, dobdob.getText());
                pst.setString(4, textM10.getText());
                pst.setString(5, textM12.getText());
                pst.setString(6, textAddress.getText());
                pst.setString(7, textPhone.getText());
                pst.setString(8, textemail.getText());
                pst.setString(9, textAadhar.getText());
                pst.setString(10, textcourse.getText());
                pst.setString(11, textbranch.getText());
                pst.setString(12, empText.getText());

                int updated = pst.executeUpdate();

                if (updated > 0) {
                    JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Could not update details.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new updateStudent();
    }
}
