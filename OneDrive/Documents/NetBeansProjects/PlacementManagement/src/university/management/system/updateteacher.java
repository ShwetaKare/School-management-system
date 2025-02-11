package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class updateteacher extends JFrame implements ActionListener {

    JTextField addressip, phoneip, emailip, educationip, departmentip;
    JLabel empid;
    Choice cempid;
    JButton submit, cancel;

    updateteacher() {
        setSize(900, 700);
        setLocation(180, 10);
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel heading1 = new JLabel("Search by Employee ID");
        heading1.setFont(new Font("serif", Font.BOLD, 20));
        heading1.setBounds(150, 100, 200, 25);
        add(heading1);

        cempid = new Choice();
        cempid.setBounds(370, 100, 150, 25);
        add(cempid);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
                cempid.add(rs.getString("empId"));
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

        JLabel rno = new JLabel("Employee ID");
        rno.setBounds(50, 200, 200, 30);
        rno.setFont(new Font("serif", Font.BOLD, 23));
        add(rno);

        empid = new JLabel();
        empid.setBounds(200, 200, 150, 30);
        add(empid);

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

        JLabel course = new JLabel("Education");
        course.setBounds(50, 400, 250, 30);
        course.setFont(new Font("serif", Font.BOLD, 23));
        add(course);

        educationip = new JTextField();
        educationip.setBounds(200, 400, 150, 30);
        add(educationip);

        JLabel branch = new JLabel("Department");
        branch.setBounds(400, 400, 250, 30);
        branch.setFont(new Font("serif", Font.BOLD, 23));
        add(branch);

        departmentip = new JTextField();
        departmentip.setBounds(650, 400, 150, 30);
        add(departmentip);

        try {
            conn c = new conn();
            String query = "select * from teacher where empId= '" + cempid.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                nameip.setText(rs.getString("name"));
                fnameip.setText(rs.getString("fname"));
                dobip.setText(rs.getString("dob"));
                empid.setText(rs.getString("empId"));
                addressip.setText(rs.getString("address"));
                xip.setText(rs.getString("class_x"));
                xiiip.setText(rs.getString("class_xii"));
                phoneip.setText(rs.getString("phone"));
                emailip.setText(rs.getString("email"));
                aadharip.setText(rs.getString("aadhar"));
                educationip.setText(rs.getString("education"));
                departmentip.setText(rs.getString("department"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {    //changes the information as the roll number changes
                try {
                    conn c = new conn();
                    String query = "select * from teacher where empId= '" + cempid.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        nameip.setText(rs.getString("name"));
                        fnameip.setText(rs.getString("fname"));
                        dobip.setText(rs.getString("dob"));
                        empid.setText(rs.getString("empId"));
                        addressip.setText(rs.getString("address"));
                        xip.setText(rs.getString("class_x"));
                        xiiip.setText(rs.getString("class_xii"));
                        phoneip.setText(rs.getString("phone"));
                        emailip.setText(rs.getString("email"));
                        aadharip.setText(rs.getString("aadhar"));
                        educationip.setText(rs.getString("education"));
                        departmentip.setText(rs.getString("department"));
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
            String education = educationip.getText(); //throws error if not typecasted because it returns object without that
            String department = departmentip.getText();

            try {
                conn c = new conn();
                String query = "update teacher set address = '" + address + "',phone = '" + phone + "',email= '" + email + "',education= '" + education + "',department ='" + department + "' where empId='" + cempid.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher's Details Updated Successfully");
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
        new updateteacher();
    }
}
