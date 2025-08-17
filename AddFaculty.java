package uni.manage.sys;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.Font.BOLD;

public class AddFaculty extends JFrame implements ActionListener
{
    JTextField textName;
    JTextField textFName,textAddress,textPhone,textMail,textM10,textM12,textAadhar;
    JLabel ID;
    JDateChooser cdob;
    JComboBox courseBox,departmentBox;
    JButton submit,cancel;

    Random ran=new Random();
    long f4=Math.abs((ran.nextLong()%90000L)+1000L);
    AddFaculty()
    {
        getContentPane().setBackground(new Color(166,164,252));



        JLabel heading=new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", BOLD,30));
        add(heading);

        //name
        JLabel name=new JLabel("Name");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif",BOLD,20));
        add(name);

        textName= new JTextField();
        textName.setBounds(200,150,200,30);
        add(textName);

        //Father's Name
        JLabel Fname =new JLabel("Father's Name");
        Fname.setBounds(420,150,200,30);
        Fname.setFont(new Font("serif",BOLD,20));
        add(Fname);

        textFName= new JTextField();
        textFName.setBounds(600,150,200,30);
        add(textFName);

        //Emplyoee ID
        JLabel empID =new JLabel("Employee ID");
        empID.setBounds(50,200,200,30);
        empID.setFont(new Font("serif",BOLD,20));
        add(empID);

        ID=new JLabel(""+f4);
        ID.setBounds(200,200,200,30);
        ID.setFont(new Font("serif",BOLD,20));
        add(ID);

        //DOB
        JLabel dob =new JLabel("Date of Birth");
        dob.setBounds(420,200,200,30);
        dob.setFont(new Font("serif",BOLD,20));
        add(dob);

        cdob=new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

        //Address
        JLabel address =new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",BOLD,20));
        add(address);

        textAddress= new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        //phone no
        JLabel phone =new JLabel("Phone No");
        phone.setBounds(420,250,200,30);
        phone.setFont(new Font("serif",BOLD,20));
        add(phone);

        textPhone= new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        //mail
        JLabel mail =new JLabel("Email Id");
        mail.setBounds(50,300,200,30);
        mail.setFont(new Font("serif",BOLD,20));
        add(mail);

        textMail= new JTextField();
        textMail.setBounds(200,300,150,30);
        add(textMail);

        JLabel aadhar =new JLabel("Aadhar No");
        aadhar.setBounds(420,300,200,30);
        aadhar.setFont(new Font("serif",BOLD,20));
        add(aadhar);

        textAadhar= new JTextField();
        textAadhar.setBounds(600,300,150,30);
        add(textAadhar);


        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(50, 350, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(200, 350, 150, 30);
        add(textM10);


        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(420, 350, 200, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(600, 350, 150, 30);
        add(textM12);

        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50, 400, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(Qualification);

        String course[] = {"B.Tech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        courseBox=new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.white);
        add(courseBox);

        JLabel Department = new JLabel("Department");
        Department.setBounds(420, 400, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        add(Department);

        String department[] = {"Computer Science","Electronics and Telecommunication","Mechanical","IT","AIML","AIDS","ECE"};
        departmentBox=new JComboBox(department);
        departmentBox.setBounds(600,400,150,30);
        departmentBox.setBackground(Color.white);
        add(departmentBox);

        submit =new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel =new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
         setLocation(350,50);
         setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //JTextField textName;
        //    JTextField textFName,textAddress,textPhone,textMail,textM10,textM12,textAadhar;
        //    JLabel ID;

        if(e.getSource()==submit)
        {
            String name=textName.getText();
            String fname= textFName.getText();
            String empId=ID.getText();
            String address=textAddress.getText();
            String phone=textPhone.getText();
            String mail=textMail.getText();
            String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String m10=textM10.getText();
            String m12=textM12.getText();
            String aadharno=textAadhar.getText();
            String course=(String)courseBox.getSelectedItem();
            String dept=(String) departmentBox.getSelectedItem();
            try{
                String q="insert into Teacher values('"+name+"','"+fname+"','"+empId+"','"+address+"','"+dob+"','"+phone+"','"+mail+"','"+m10+"','"+m12+"','"+aadharno+"','"+course+"','"+dept+"')";
                Conn c=new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details have been saved.");
                setVisible(false);

            }
            catch(Exception E)
            {
                E.printStackTrace();
            }

        }else
        {
            setVisible(false);
        }

    }

    public static void main(String[] args)
    {
        new AddFaculty();
    }
}
