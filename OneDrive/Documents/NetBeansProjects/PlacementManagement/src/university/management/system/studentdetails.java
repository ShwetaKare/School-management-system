package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;  //helps to insert values directly in the table
import java.awt.event.*;  //for action listener

public class studentdetails extends JFrame implements ActionListener {

    Choice crollno;  //choice displays a pop up menu where user can choose anything from
    JTable tab;
    JButton search, print, update, add, cancel;

    studentdetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
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

        tab = new JTable();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            tab.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(tab);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(180, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student where rollno= '" + crollno.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                tab.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {

            }
        } else if (ae.getSource() == print) {
            try {
                tab.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new addstudent();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new updatestudent();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new studentdetails();
    }
}
