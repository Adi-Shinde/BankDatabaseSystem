package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class balanceenquiry extends JFrame implements ActionListener {
int balance = 0;
    JTextField amount;
    JButton withdraw, back;
    String passwordnumber;

    balanceenquiry(String passwordnumber) {

        this.passwordnumber = passwordnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2); // corrected line
        JLabel image = new JLabel(i3); // set the ImageIcon to the JLabel
        image.setBounds(0, 0, 1024, 768);
        add(image);

        back = new JButton("Back");
        back.setBounds(437, 380, 150, 30);
        back.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        back.addActionListener(this);
        image.add(back);

        conn c = new conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='" + passwordnumber + "'");
            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                } else {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
                System.out.println(e);
            }
        
        JLabel text =   new JLabel("Your current account balance is $"+balance);
        text.setFont(new Font("", Font.BOLD, 17));
        text.setForeground(Color.WHITE);
        text.setBounds(230,190,400,30);
        image.add(text);
                
        setSize(1024, 805);
        setLocationRelativeTo(null); // this will center the JFrame on the screen
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new transactions(passwordnumber).setVisible(true);
    }

    public static void main(String args[]) {
        new balanceenquiry("");
    }
}
