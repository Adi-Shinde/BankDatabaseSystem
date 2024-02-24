package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
//5040935999454845

public class ministatement extends JFrame implements ActionListener {

    JButton b1, b2;
    JLabel l1;
    String passwordnumber;

    ministatement(String passwordnumber) {
        this.passwordnumber = passwordnumber;
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        setTitle("Mini-Statement");
        l1 = new JLabel();
        add(l1);

        JLabel l2 = new JLabel("Canadian Bank");
        l2.setBounds(150, 20, 120, 20);
        l2.setFont(new Font("", Font.BOLD, 16));
        add(l2);

        JLabel l3 = new JLabel();
        l3.setFont(new Font("", Font.BOLD, 13));
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
         l4.setFont(new Font("", Font.BOLD, 15));
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try {

            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_number = '" + passwordnumber + "'");

            while (rs.next()) {
                l3.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("card_number").substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            conn c1 = new conn();
            int balance = 0;
            ResultSet rs = c1.s.executeQuery("select * from bank where pinnumber= '" + passwordnumber + "'");
            while (rs.next()) {
                l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                } else {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your Current Account Balance is $" + balance);

        } catch (Exception e) {
            System.out.println(e);
        }
        setLayout(null);
        b1 = new JButton("Exit");
    
        b1.addActionListener(this);

        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String args[]) {
        new ministatement("").setVisible(true);
    }
}
