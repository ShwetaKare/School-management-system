/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

/**
 *
 * @author shwet
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class addstudent extends JFrame implements ActionListener {

    JTextField nameip, fnameip, addressip, phoneip, emailip, xip, xiiip, aadharip;
    JLabel rnoip;
    JDateChooser dobip;
    JComboBox courseip, branchip;  //dropdown
    JButton submit, cancel;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    addstudent() {
        setSize(900, 700);
        setLocation(180, 10);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 23));
        add(name);

        nameip = new JTextField();
        nameip.setBounds(200, 150, 150, 30);
        add(nameip);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 23));
        add(fname);

        fnameip = new JTextField();
        fnameip.setBounds(650, 150, 150, 30);
        add(fnameip);

        JLabel rno = new JLabel("Roll No.");
        rno.setBounds(50, 200, 200, 30);
        rno.setFont(new Font("serif", Font.BOLD, 23));
        add(rno);

        rnoip = new JLabel("1533" + first4);
        rnoip.setBounds(200, 200, 150, 30);
        rnoip.setFont(new Font("serif", Font.BOLD, 30));
        add(rnoip);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 23));
        add(dob);

        dobip = new JDateChooser();
        dobip.setBounds(650, 200, 150, 30);
        dobip.setFont(new Font("serif", Font.BOLD, 30));
        add(dobip);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 23));
        add(address);

        addressip = new JTextField();
        addressip.setBounds(200, 250, 150, 30);
        addressip.setFont(new Font("serif", Font.BOLD, 30));
        add(addressip);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 23));
        add(phone);

        phoneip = new JTextField();
        phoneip.setBounds(650, 250, 150, 30);
        phoneip.setFont(new Font("serif", Font.BOLD, 30));
        add(phoneip);

        JLabel email = new JLabel("Email Id");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 23));
        add(email);

        emailip = new JTextField();
        emailip.setBounds(200, 300, 150, 30);
        emailip.setFont(new Font("serif", Font.BOLD, 30));
        add(emailip);

        JLabel xmarks = new JLabel("Class X (%)");
        xmarks.setBounds(400, 300, 200, 30);
        xmarks.setFont(new Font("serif", Font.BOLD, 23));
        add(xmarks);

        xip = new JTextField();
        xip.setBounds(650, 300, 150, 30);
        xip.setFont(new Font("serif", Font.BOLD, 30));
        add(xip);

        JLabel xiimarks = new JLabel("Class XII (%)");
        xiimarks.setBounds(50, 350, 250, 30);
        xiimarks.setFont(new Font("serif", Font.BOLD, 23));
        add(xiimarks);

        xiiip = new JTextField();
        xiiip.setBounds(200, 350, 150, 30);
        xiiip.setFont(new Font("serif", Font.BOLD, 30));
        add(xiiip);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 250, 23);
        aadhar.setFont(new Font("serif", Font.BOLD, 23));
        add(aadhar);

        aadharip = new JTextField();
        aadharip.setBounds(650, 350, 150, 30);
        aadharip.setFont(new Font("serif", Font.BOLD, 30));
        add(aadharip);

        JLabel course = new JLabel("Course");
        course.setBounds(50, 400, 250, 30);
        course.setFont(new Font("serif", Font.BOLD, 23));
        add(course);

        String courses[] = {"B.Tech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        courseip = new JComboBox(courses);
        courseip.setBounds(200, 400, 150, 30);
        courseip.setFont(new Font("serif", Font.BOLD, 23));
        courseip.setBackground(Color.WHITE);
        add(courseip);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(400, 400, 250, 30);
        branch.setFont(new Font("serif", Font.BOLD, 23));
        add(branch);

        String branches[] = {"CSE", "IT", "Electronics", "EXTC", "Electrical", "Civil", "Mechanical", "Production", "Textile", "Chemistry"};
        branchip = new JComboBox(branches);
        branchip.setBounds(650, 400, 150, 30);
        branchip.setFont(new Font("serif", Font.BOLD, 23));
        branchip.setBackground(Color.WHITE);
        add(branchip);

        submit = new JButton("Submit");
        submit.setBounds(400, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = nameip.getText();
            String fname = fnameip.getText();
            String rollno = rnoip.getText();
            String dob = ((JTextField) dobip.getDateEditor().getUiComponent()).getText();
            String address = addressip.getText();
            String phone = phoneip.getText();
            String email = emailip.getText();
            String x = xip.getText();
            String xii = xiiip.getText();
            String aadhar = aadharip.getText();
            String course = (String) courseip.getSelectedItem(); //throws error if not typecasted because it returns object without that
            String branch = (String) branchip.getSelectedItem();

            try {
                conn c = new conn();
                String query = "insert into student values('" + name + "','" + fname + "','" + rollno + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + x + "','" + xii + "','" + aadhar + "','" + course + "','" + branch + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
                c.s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addstudent();
    }
}
