package uni.manage.sys;

import com.toedter.calendar.JDateChooser; // Make sure this library is included in your project
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import static java.awt.Font.BOLD;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField textAddress, textPhone, textEmail, textAadhar, textCourse, textBranch;
    JLabel ID, textName, textFName, dobLabel, textM10, textM12;
    JButton submit, cancel;
    Choice cID;

    UpdateStudent() {
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", BOLD, 35));
        add(heading);

        JLabel empID = new JLabel("Select Roll No");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);

        cID = new Choice();
        cID.setBounds(250, 100, 200, 20);
        add(cID);
        loadStudentRollNumbers();

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 200, 30);
        name.setFont(new Font("serif", BOLD, 20));
        add(name);
        textName = new JLabel(); // Change to JLabel to match existing code
        textName.setBounds(200, 150, 200, 30);
        add(textName);

        // Father's Name
        JLabel Fname = new JLabel("Father's Name");
        Fname.setBounds(420, 150, 200, 30);
        Fname.setFont(new Font("serif", BOLD, 20));
        add(Fname);
        textFName = new JLabel(); // Change to JLabel to match existing code
        textFName.setBounds(600, 150, 200, 30);
        add(textFName);

        // Roll No
        JLabel rollNo = new JLabel("Roll No");
        rollNo.setBounds(50, 200, 200, 30);
        rollNo.setFont(new Font("serif", BOLD, 20));
        add(rollNo);
        ID = new JLabel();
        ID.setBounds(200, 200, 200, 30);
        ID.setFont(new Font("serif", BOLD, 20));
        add(ID);

        // DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(420, 200, 200, 30);
        dob.setFont(new Font("serif", BOLD, 20));
        add(dob);
        dobLabel = new JLabel(); // Change to JLabel to match existing code
        dobLabel.setBounds(600, 200, 150, 30);
        dobLabel.setFont(new Font("serif", BOLD, 20));
        add(dobLabel);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", BOLD, 20));
        add(address);
        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        // Phone No
        JLabel phone = new JLabel("Phone No");
        phone.setBounds(420, 250, 200, 30);
        phone.setFont(new Font("serif", BOLD, 20));
        add(phone);
        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        add(textPhone);

        // Email
        JLabel email = new JLabel("Email Id");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", BOLD, 20));
        add(email);
        textEmail = new JTextField();
        textEmail.setBounds(200, 300, 150, 30);
        add(textEmail);

        // Aadhar No
        JLabel aadhar = new JLabel("Aadhar No");
        aadhar.setBounds(420, 300, 200, 30);
        aadhar.setFont(new Font("serif", BOLD, 20));
        add(aadhar);
        textAadhar = new JTextField();
        textAadhar.setBounds(600, 300, 150, 30);
        add(textAadhar);

        // Class X
        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(50, 350, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);
        textM10 = new JLabel(); // Change to JLabel to match existing code
        textM10.setBounds(200, 350, 150, 30);
        add(textM10);

        // Class XII
        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(420, 350, 200, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);
        textM12 = new JLabel(); // Change to JLabel to match existing code
        textM12.setBounds(600, 350, 150, 30);
        add(textM12);

        // Course
        JLabel course = new JLabel("Course");
        course.setBounds(50, 400, 200, 30);
        course.setFont(new Font("serif", BOLD, 20));
        add(course);
        textCourse = new JTextField();
        textCourse.setBounds(200, 400, 200, 30);
        add(textCourse);

        // Branch
        JLabel branch = new JLabel("Branch");
        branch.setBounds(420, 400, 200, 30);
        branch.setFont(new Font("serif", BOLD, 20));
        add(branch);
        textBranch = new JTextField();
        textBranch.setBounds(600, 400, 150, 30);
        add(textBranch);

        // Load student details when selecting a Roll No
        cID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadStudentDetails((String) cID.getSelectedItem());
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    private void loadStudentRollNumbers() {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Student");
            while (resultSet.next()) {
                cID.add(resultSet.getString("RollNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStudentDetails(String rollNo) {
        try {
            Conn c = new Conn();
            String q = "select * from Student where RollNo = '" + rollNo + "'";
            ResultSet resultSet = c.statement.executeQuery(q);
            if (resultSet.next()) {
                textName.setText(resultSet.getString("Name"));
                textFName.setText(resultSet.getString("Fname"));
                dobLabel.setText(resultSet.getString("dob"));
                textAadhar.setText(resultSet.getString("aadhar"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_10"));
                textM12.setText(resultSet.getString("c1ass_12"));
                textAddress.setText(resultSet.getString("address"));
                ID.setText(resultSet.getString("RollNo"));
                textCourse.setText(resultSet.getString("Course"));
                textBranch.setText(resultSet.getString("Branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String rollNo = cID.getSelectedItem();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String course = textCourse.getText();
            String branch = textBranch.getText();
            try {
                Conn c = new Conn();
                String query = "update Student set address='" + address + "', phone='" + phone + "', email='" + email + "', Course='" + course + "', Branch='" + branch + "' where RollNo='" + rollNo + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
