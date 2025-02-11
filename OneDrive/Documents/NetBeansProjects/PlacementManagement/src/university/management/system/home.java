/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

/**
 *
 * @author shwet
 */
import javax.swing.*; //java's extended package contains swing library which is used to display frames
import java.awt.*; // It provides a collection of pre-built classes for creating and managing graphical components such as windows, buttons, and menus

public class home extends JFrame implements Runnable {

    Thread t;

    home() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/vjtiquaf.jpg")); // for uploading images
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT); // for resizing or scaling the image
        ImageIcon i3 = new ImageIcon(i2); // again make object of i2
        JLabel label = new JLabel(i3); // object of image
        add(label); // adds the image on page
        t = new Thread(this);
        t.start(); // this method internally calls run method

        setVisible(true); // makes the frame visible
        int x = 1;
        for (int i = 2; i <= 600; i += 4) {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2)); // sets its position on the screen from up and side
            setSize(i + 3 * x, i + x / 2); // sets size of the frame

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public void run() {
        try {
            Thread.sleep(7000); // it will automatcially turn off the frame in 7 seconds
            setVisible(false);

            // next frame
            new login(); // now after 7sec login page will appear
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new home();
    }

}
