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
import java.awt.event.*;

public class project extends JFrame implements ActionListener {

    project() {
        setSize(1500, 800);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/vjti4.jpg")); // for uploading images
        Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT); // for resizing or scaling the image
        ImageIcon i3 = new ImageIcon(i2); // again make object of i2
        JLabel label = new JLabel(i3); // object of image
        add(label); // adds the image on page

        JMenuBar mb = new JMenuBar(); //creates a menubar

        //add information
        JMenu newinfo = new JMenu("New Information"); //creates contents in menubar
        newinfo.setForeground(Color.BLUE);
        mb.add(newinfo);

        JMenuItem facultyinfo = new JMenuItem("New Faculty Information"); //adds content in menu
        facultyinfo.setForeground(Color.BLUE);
        facultyinfo.addActionListener(this);
        newinfo.add(facultyinfo);

        JMenuItem studentinfo = new JMenuItem("New Student Information");
        studentinfo.setForeground(Color.BLUE);
        studentinfo.addActionListener(this);
        newinfo.add(studentinfo);

        //view information
        JMenu details = new JMenu("View Details"); //creates contents in menubar
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Information"); //adds content in menu
        facultydetails.setForeground(Color.RED);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Information");
        studentdetails.setForeground(Color.RED);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        //apply leave
        JMenu leave = new JMenu("Apply Leave"); //creates contents in menubar
        leave.setForeground(Color.GREEN);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave"); //adds content in menu
        facultyleave.setForeground(Color.GREEN);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setForeground(Color.GREEN);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        //leave details
        JMenu leavedetails = new JMenu("View Leave Details"); //creates contents in menubar
        leavedetails.setForeground(Color.BLUE);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details"); //adds content in menu
        facultyleavedetails.setForeground(Color.BLUE);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setForeground(Color.BLUE);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);

        //Exam results
        JMenu exam = new JMenu("Examination"); //creates contents in menubar
        exam.setForeground(Color.RED);
        mb.add(exam);

        JMenuItem examdetails = new JMenuItem("Examination Results"); //adds content in menu
        examdetails.setForeground(Color.RED);
          examdetails.addActionListener(this);
        exam.add(examdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setForeground(Color.RED);
          entermarks.addActionListener(this);
        exam.add(entermarks);

        //Update Info
        JMenu updateinfo = new JMenu("Update Information"); //creates contents in menubar
        updateinfo.setForeground(Color.GREEN);
        mb.add(updateinfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Information"); //adds content in menu
        updatefacultyinfo.setForeground(Color.GREEN);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Information");
        updatestudentinfo.setForeground(Color.GREEN);
        updatestudentinfo.addActionListener(this);
        updateinfo.add(updatestudentinfo);

        //Fees
        JMenu fees = new JMenu("Fees Section"); //creates contents in menubar
        fees.setForeground(Color.BLUE);
        mb.add(fees);

        JMenuItem feestructure = new JMenuItem("Fee Structure"); //adds content in menu
        feestructure.setForeground(Color.BLUE);
        feestructure.addActionListener(this);
        fees.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setForeground(Color.BLUE);
        feeform.addActionListener(this);
        fees.add(feeform);

        //Utilities
        JMenu utilites = new JMenu("Utilities"); //creates contents in menubar
        utilites.setForeground(Color.RED);
        mb.add(utilites);

        JMenuItem notepad = new JMenuItem("Notepad"); //adds content in menu
        notepad.setForeground(Color.RED);
        notepad.addActionListener(this);
        utilites.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setForeground(Color.RED);
        calculator.addActionListener(this);
        utilites.add(calculator);

        //about
        JMenu about = new JMenu("About");
        about.setForeground(Color.GREEN);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        //Exit
        JMenu exit = new JMenu("Exit"); //creates contents in menubar
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit"); //adds content in menu
        ex.setForeground(Color.GREEN);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe"); //runs the outside function which is not in the program
            } catch (Exception e) {
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe"); //runs the outside function which is not in the program
            } catch (Exception e) {
            }
        } else if (msg.equals("New Faculty Information")) {
            new addteacher();
        } else if (msg.equals("New Student Information")) {
            new addstudent();
        } else if (msg.equals("View Student Information")) {
            new studentdetails();
        } else if (msg.equals("View Faculty Information")) {
            new teacherdetails();
        } else if (msg.equals("Faculty Leave")) {
            new teacherleave();
        } else if (msg.equals("Student Leave")) {
            new studentleave();
        } else if (msg.equals("Student Leave Details")) {
            new studentleavedetails();
        } else if (msg.equals("Faculty Leave Details")) {
            new teacherleavedetails();
        } else if (msg.equals("Update Faculty Information")) {
            new updateteacher();
        } else if (msg.equals("Update Student Information")) {
            new updatestudent();
        } else if (msg.equals("Enter Marks")) {
            new entermarks();
        } else if (msg.equals("Examination Results")) {
            new examinationdetails();
        } else if (msg.equals("Fee Structure")) {
            new feestructure();
        } else if (msg.equals("About")) {
            new about();
        } else if (msg.equals("Student Fee Form")) {
            new studentfeeform();
        }
    }

    public static void main(String[] args) {
        new project();
    }
}
