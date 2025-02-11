package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class updatestudent extends JFrame implements ActionListener {

    JTextField addressip, phoneip, emailip, courseip, branchip;
    JLabel rnoip;
    Choice crollno;
    JButton submit, cancel;

    updatestudent() {
        setSize(900, 700);
        setLocation(180, 10);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel heading1 = new JLabel("Search by Roll Number");
        heading1.setFont(new Font("serif", Font.BOLD, 20));
        heading1.setBounds(150, 100, 200, 25);
        add(heading1);

        crollno = new Choice();
        crollno.setBounds(370, 100, 150, 25);
        add(crollno);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 23));
        add(name);

        JLabel nameip = new JLabel();
        nameip.setBounds(200, 150, 150, 30);
        add(nameip);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 23));
        add(fname);

        JLabel fnameip = new JLabel();
        fnameip.setBounds(650, 150, 150, 30);
        add(fnameip);

        JLabel rno = new JLabel("Roll No.");
        rno.setBounds(50, 200, 200, 30);
        rno.setFont(new Font("serif", Font.BOLD, 23));
        add(rno);

        rnoip = new JLabel();
        rnoip.setBounds(200, 200, 150, 30);
        add(rnoip);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 23));
        add(dob);

        JLabel dobip = new JLabel();
        dobip.setBounds(650, 200, 150, 30);
        add(dobip);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 23));
        add(address);

        addressip = new JTextField();
        addressip.setBounds(200, 250, 150, 30);
        add(addressip);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 23));
        add(phone);

        phoneip = new JTextField();
        phoneip.setBounds(650, 250, 150, 30);
        add(phoneip);

        JLabel email = new JLabel("Email Id");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 23));
        add(email);

        emailip = new JTextField();
        emailip.setBounds(200, 300, 150, 30);
        add(emailip);

        JLabel xmarks = new JLabel("Class X (%)");
        xmarks.setBounds(400, 300, 200, 30);
        xmarks.setFont(new Font("serif", Font.BOLD, 23));
        add(xmarks);

        JLabel xip = new JLabel();
        xip.setBounds(650, 300, 150, 30);
        add(xip);

        JLabel xiimarks = new JLabel("Class XII (%)");
        xiimarks.setBounds(50, 350, 250, 30);
        xiimarks.setFont(new Font("serif", Font.BOLD, 23));
        add(xiimarks);

        JLabel xiiip = new JLabel();
        xiiip.setBounds(200, 350, 150, 30);
        add(xiiip);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 250, 23);
        aadhar.setFont(new Font("serif", Font.BOLD, 23));
        add(aadhar);

        JLabel aadharip = new JLabel();
        aadharip.setBounds(650, 350, 150, 30);
        add(aadharip);

        JLabel course = new JLabel("Course");
        course.setBounds(50, 400, 250, 30);
        course.setFont(new Font("serif", Font.BOLD, 23));
        add(course);

        courseip = new JTextField();
        courseip.setBounds(200, 400, 150, 30);
        add(courseip);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(400, 400, 250, 30);
        branch.setFont(new Font("serif", Font.BOLD, 23));
        add(branch);

        branchip = new JTextField();
        branchip.setBounds(650, 400, 150, 30);
        add(branchip);

        try {
            conn c = new conn();
            String query = "select * from student where rollno= '" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                nameip.setText(rs.getString("name"));
                fnameip.setText(rs.getString("fname"));
                dobip.setText(rs.getString("dob"));
                rnoip.setText(rs.getString("rollno"));
                addressip.setText(rs.getString("address"));
                xip.setText(rs.getString("class_x"));
                xiiip.setText(rs.getString("class_xii"));
                phoneip.setText(rs.getString("phone"));
                emailip.setText(rs.getString("email"));
                aadharip.setText(rs.getString("aadhar"));
                courseip.setText(rs.getString("course"));
                branchip.setText(rs.getString("branch"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {    //changes the information as the roll number changes
                try {
                    conn c = new conn();
                    String query = "select * from student where rollno= '" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        nameip.setText(rs.getString("name"));
                        fnameip.setText(rs.getString("fname"));
                        dobip.setText(rs.getString("dob"));
                        rnoip.setText(rs.getString("rollno"));
                        addressip.setText(rs.getString("address"));
                        xip.setText(rs.getString("class_x"));
                        xiiip.setText(rs.getString("class_xii"));
                        phoneip.setText(rs.getString("phone"));
                        emailip.setText(rs.getString("email"));
                        aadharip.setText(rs.getString("aadhar"));
                        courseip.setText(rs.getString("course"));
                        branchip.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
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
            String address = addressip.getText();
            String phone = phoneip.getText();
            String email = emailip.getText();
            String course = courseip.getText(); //throws error if not typecasted because it returns object without that
            String branch = branchip.getText();

            try {
                conn c = new conn();
                String query = "update student set address = '" + address + "',phone = '" + phone + "',email= '" + email + "',course= '" + course + "',branch ='" + branch + "' where rollno='" + crollno.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
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
        new updatestudent();
    }
}
