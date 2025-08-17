package uni.manage.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        // Image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        // New Information menu
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // Details menu
        JMenu newdetails = new JMenu("New Details");
        newdetails.setForeground(Color.BLACK);
        mb.add(newdetails);

        JMenuItem facultydetails = new JMenuItem("New Faculty Details");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        newdetails.add(facultydetails);

        JMenuItem studendetails = new JMenuItem("New Student Details");
        studendetails.setBackground(Color.white);
        studendetails.addActionListener(this);
        newdetails.add(studendetails);

        // Leave menu
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Leave Details menu
        JMenu leavedetail = new JMenu("Leave Details");
        leavedetail.setForeground(Color.BLACK);
        mb.add(leavedetail);

        JMenuItem facultyleavedetail = new JMenuItem("Faculty Leave Details");
        facultyleavedetail.setBackground(Color.white);
        facultyleavedetail.addActionListener(this);
        leavedetail.add(facultyleavedetail);

        JMenuItem studentLeavedetail = new JMenuItem("Student Leave Details");
        studentLeavedetail.setBackground(Color.white);
        studentLeavedetail.addActionListener(this);
        leavedetail.add(studentLeavedetail);

        // Exams menu
        JMenu exam = new JMenu("Examinations");
        exam.setForeground(Color.BLACK);
        mb.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Result");
        ExaminationDetails.setBackground(Color.white);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.white);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        // Update Info menu
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);

        JMenuItem UpdateFacultyInfo = new JMenuItem("Update Faculty Details");
        UpdateFacultyInfo.setBackground(Color.white);
        UpdateFacultyInfo.addActionListener(this);
        updateInfo.add(UpdateFacultyInfo);

        JMenuItem UpdateStudentInfo = new JMenuItem("Update Student Details");
        UpdateStudentInfo.setBackground(Color.white);
        UpdateStudentInfo.addActionListener(this);
        updateInfo.add(UpdateStudentInfo);

        // Utility menu
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.white);
        Calculator.addActionListener(this);
        utility.add(Calculator);

        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setBackground(Color.white);
        Notepad.addActionListener(this);
        utility.add(Notepad);

        // About menu
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.white);
        About.addActionListener(this);
        about.add(About);

        // Exit menu
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);

        setJMenuBar(mb);
        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")) {
            System.exit(0);
        } else if (sm.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
        } else if (sm.equals("New Faculty Details")) {
            new FacultyDetails();
        } else if (sm.equals("New Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new FacultyLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Examination Result")) {  // Fixed this label
            new ExaminationDetails();
        } else if (sm.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
