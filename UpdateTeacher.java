package uni.manage.sys;

import com.toedter.calendar.JDateChooser; // Make sure this library is included in your project
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.awt.Font.BOLD;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField textAddress, textPhone, textMail, textAadhar, textCourse, textDept;
    JLabel ID, textName, textFName, dobdob, textM10, textM12;
    JButton submit, cancel;
    Choice cID;

    UpdateTeacher() {
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", BOLD, 35));
        add(heading);

        JLabel empID = new JLabel("Select Employee ID");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);

        cID = new Choice();
        cID.setBounds(250, 100, 200, 20);
        add(cID);
        loadEmployeeIDs();

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

        // Employee ID
        JLabel EmpID = new JLabel("Employee ID");
        EmpID.setBounds(50, 200, 200, 30);
        EmpID.setFont(new Font("serif", BOLD, 20));
        add(EmpID);
        ID = new JLabel();
        ID.setBounds(200, 200, 200, 30);
        ID.setFont(new Font("serif", BOLD, 20));
        add(ID);

        // DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(420, 200, 200, 30);
        dob.setFont(new Font("serif", BOLD, 20));
        add(dob);
        dobdob = new JLabel(); // Change to JLabel to match existing code
        dobdob.setBounds(600, 200, 150, 30);
        dobdob.setFont(new Font("serif", BOLD, 20));
        add(dobdob);

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
        JLabel mail = new JLabel("Email Id");
        mail.setBounds(50, 300, 200, 30);
        mail.setFont(new Font("serif", BOLD, 20));
        add(mail);
        textMail = new JTextField();
        textMail.setBounds(200, 300, 150, 30);
        add(textMail);

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

        // Qualification
        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50, 400, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(Qualification);
        textCourse = new JTextField();
        textCourse.setBounds(200, 400, 200, 30);
        add(textCourse);

        // Department
        JLabel Department = new JLabel("Department");
        Department.setBounds(420, 400, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        add(Department);
        textDept = new JTextField();
        textDept.setBounds(600, 400, 150, 30);
        add(textDept);

        // Load teacher details when selecting an ID
        cID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadTeacherDetails((String) cID.getSelectedItem());
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

    private void loadEmployeeIDs() {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Teacher");
            while (resultSet.next()) {
                cID.add(resultSet.getString("EmpID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadTeacherDetails(String empID) {
        try {
            Conn c = new Conn();
            String q = "select * from Teacher where EmpID = '" + empID + "'";
            ResultSet resultSet = c.statement.executeQuery(q);
            if (resultSet.next()) {
                textName.setText(resultSet.getString("Name"));
                textFName.setText(resultSet.getString("Fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAadhar.setText(resultSet.getString("aadhar"));
                textPhone.setText(resultSet.getString("phone"));
                textMail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_10"));
                textM12.setText(resultSet.getString("c1ass_12"));
                textAddress.setText(resultSet.getString("address"));
                ID.setText(resultSet.getString("EmpID"));
                textCourse.setText(resultSet.getString("qualification"));
                textDept.setText(resultSet.getString("dept"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String empID = cID.getSelectedItem();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textMail.getText();
            String qualification = textCourse.getText();
            String dept = textDept.getText();
            try
            { Conn c = new Conn();


                String query = "update Teacher set   address='" + address + "', phone='" + phone + "', email='" + email + "', dept='" + dept + "' where EmpID = '" + empID + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }



        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}