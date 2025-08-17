package uni.manage.sys;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FacultyLeave extends JFrame implements ActionListener
{
    Choice choiceRollNo, choTime;
    JDateChooser selDate;
    JButton submit, cancel;

    FacultyLeave() {
        getContentPane().setBackground(new Color(210, 232, 252));

        JLabel heading = new JLabel("Apply for Leave (Faculty)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel RollNoSe = new JLabel("Search By Employee ID");
        RollNoSe.setBounds(60, 100, 300, 20);
        RollNoSe.setFont(new Font("serif", Font.PLAIN, 20));
        add(RollNoSe);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(60, 130, 200, 20);
        add(choiceRollNo);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Teacher");
            while (resultSet.next()) {
                choiceRollNo.add(resultSet.getString("EmpID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel ldate = new JLabel("Date");
        ldate.setBounds(60, 180, 200, 20);
        ldate.setFont(new Font("serif", Font.PLAIN, 18));
        add(ldate);

        selDate = new JDateChooser();
        selDate.setBounds(60, 210, 200, 25);
        add(selDate);

        JLabel time = new JLabel("Duration of Leave");
        time.setBounds(60, 260, 200, 20);
        time.setFont(new Font("serif", Font.PLAIN, 18));
        add(time);

        choTime = new Choice();
        choTime.setBounds(60, 290, 200, 20);
        choTime.add("Full Day");
        choTime.add("Half Day");
        add(choTime);

        submit = new JButton("Submit");
        submit.setBounds(100, 350, 100, 25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, 350, 100, 25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String EmpID = choiceRollNo.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time = choTime.getSelectedItem();

            String q = "insert into TeacherLeave values('" + EmpID + "','" + date + "','" + time + "')";
            try {
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }


    }

    public static void main(String[] args)
    {
        new FacultyLeave();
    }
}

