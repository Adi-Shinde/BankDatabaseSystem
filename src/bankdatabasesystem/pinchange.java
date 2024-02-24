package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class pinchange extends JFrame implements ActionListener {

    JPasswordField newpin, newpinch;
    JButton change, back;
    String passwordnumber;

    pinchange(String passwordnumber) {
        this.passwordnumber = passwordnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2); // corrected line
        JLabel image = new JLabel(i3); // set the ImageIcon to the JLabel
        image.setBounds(0, 0, 1024, 768);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(335, 150, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 17));
        image.add(text);

        newpin = new JPasswordField();
        newpin.setFont(new Font("Raleway", Font.BOLD, 22));
        newpin.setBounds(380, 225, 200, 25);
        image.add(newpin);

        JLabel text1 = new JLabel("New PIN:");
        text1.setBounds(225, 180, 700, 35);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System", Font.BOLD, 16));
        image.add(text1);

        JLabel text2 = new JLabel("Re-Enter New PIN:");
        text2.setBounds(225, 220, 700, 35);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System", Font.BOLD, 16));
        image.add(text2);

        newpinch = new JPasswordField();
        newpinch.setFont(new Font("Raleway", Font.BOLD, 22));
        newpinch.setBounds(380, 185, 200, 25);
        image.add(newpinch);

        change = new JButton("Confirm Change");
        change.setBounds(225, 380, 150, 30);
        change.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(437, 380, 150, 30);
        back.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        back.addActionListener(this);
        image.add(back);

        setSize(1024, 805);
        setLocationRelativeTo(null); // this will center the JFrame on the screen
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = newpin.getText();
                String rpin = newpinch.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "The two pins do not match.");
                    return;
                }
                if (npin.equals("") || rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pin Text Box should not be left blank");
                return;
                }
              boolean isNumeric1 = npin.matches("\\d+");
              boolean isNumeric2 = rpin.matches("\\d+");
                if (isNumeric1 == false || isNumeric2 == false || npin.length() != 4 || rpin.length() != 4) {
                     JOptionPane.showMessageDialog(null, "Make sure the PIN is numbers and is 4 digits only.");
                return; 
                }

                conn c = new conn();
                String query1 = "update bank set pinnumber='" + rpin + "' where pinnumber='" + passwordnumber + "'";
                String query2 = "update login set pin_number='" + rpin + "' where pin_number='" + passwordnumber + "'";
                String query3 = "update signupthree set pinnumber='" + rpin + "' where pinnumber='" + passwordnumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");

                setVisible(false);
                new transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new transactions(passwordnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new pinchange("");
    }

}
