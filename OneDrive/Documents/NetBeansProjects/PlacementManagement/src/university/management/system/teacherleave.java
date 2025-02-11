package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class teacherleave extends JFrame implements ActionListener {
    Choice cempId , ctime;
    JDateChooser dol;
    JButton cancel , submit;
    teacherleave(){
        setSize(500, 550);
        setLocation(400, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(130,20,300,40);
        heading.setFont(new Font("Tahoma" , Font.BOLD,20));
        add(heading);
        
        JLabel heading1 = new JLabel("Search by Employee ID");
        heading1.setBounds(20,70,300,30);
        heading1.setFont(new Font("Tahoma" , Font.BOLD,15));
        add(heading1);
       
        cempId = new Choice();
        cempId.setBounds(20,100,200,30);
        add(cempId);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel date = new JLabel("Date");
        date.setBounds(20, 140, 200, 30);
        date.setFont(new Font("Tahoma" , Font.BOLD, 15));
        add(date);
        
        dol = new JDateChooser();
        dol.setBounds(20, 170, 200, 30);
        dol.setFont(new Font("Tahoma" , Font.BOLD, 15));
        add(dol);
        
        JLabel time = new JLabel("Time Duration");
        time.setBounds(20,210,300,30);
        time.setFont(new Font("Tahoma" , Font.BOLD,15));
        add(time);
       
        ctime = new Choice();
        ctime.setBounds(20,240,200,20);
         ctime.setFont(new Font("Tahoma" , Font.BOLD,15));
        ctime.add("Half Day");
        ctime.add("Full Day");
        add(ctime);
        
         submit = new JButton("Submit");
        submit.setBounds(20, 300, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(submit);
        
          cancel = new JButton("Cancel");
        cancel.setBounds(150, 300, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
             String empId = cempId.getSelectedItem();
            String date = ((JTextField)dol.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into teacherleave values('"+empId+"','"+date+"','"+duration+"')";
            try{
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Leave Confirmed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new teacherleave();
    }
}
