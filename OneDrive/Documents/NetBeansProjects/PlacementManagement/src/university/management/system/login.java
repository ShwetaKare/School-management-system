/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

/**
 *
 * @author shwet
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField usernameip, passwordip;

    login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username = new JLabel("Username"); // used to give labels or addtext
        username.setBounds(40, 20, 100, 20); // justifys the position of the label on the screen
        add(username);
        usernameip = new JTextField(); // used for input
        usernameip.setBounds(150, 20, 150, 20);
        add(usernameip);

        JLabel password = new JLabel("Password"); // used to give labels or addtext
        password.setBounds(40, 70, 100, 20); // justifys the position of the label on the screen
        add(password);
        passwordip = new JPasswordField(); // used for input and specially for passwords
        passwordip.setBounds(150, 70, 150, 20);
        add(passwordip);

        login = new JButton("Login");
        login.setBounds(50, 120, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(190, 120, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/user.png")); // for uploading images
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // for resizing or scaling the image
        ImageIcon i3 = new ImageIcon(i2); // again make object of i2
        JLabel label = new JLabel(i3); // object of image
        label.setBounds(350, 0, 200, 200);
        add(label); // adds the image on page

        setSize(600, 300);
        setLocation(450, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) { // performs actions for buttons
        if (ae.getSource() == login) {
            String username = usernameip.getText();
            String password = passwordip.getText();

            String query = "select * from login where username='" + username + "'and password='" + password + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
                c.s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false); // makes sure when u click on cancel button screen disappears
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
