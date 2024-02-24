package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {

    JButton cash1, cash2, cash3, cash4, cash5, cash6, back;
    String passwordnumber;

    fastcash(String passwordnumber) {
        this.passwordnumber = passwordnumber;
        setLayout(null);

        
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2); // corrected line
        JLabel image = new JLabel(i3); // set the ImageIcon to the JLabel
        image.setBounds(0, 0, 1024, 768);
        add(image);

        JLabel text = new JLabel("");
        text.setBounds(330, 150, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel text1 = new JLabel("Select Withdrawal Amount");
        text1.setBounds(310, 175, 700, 35);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System", Font.BOLD, 16));
        image.add(text1);

        cash1 = new JButton("$20");
        cash1.setBounds(225, 255, 150, 30);
        cash1.setFont(new Font("", Font.BOLD, 12));
        cash1.addActionListener(this);
        image.add(cash1);

        cash2 = new JButton("$50");
        cash2.setBounds(437, 255, 150, 30);
        cash2.setFont(new Font("", Font.BOLD, 12));
        cash2.addActionListener(this);
        image.add(cash2);

        cash3 = new JButton("$100");
        cash3.setBounds(225, 298, 150, 30);
        cash3.setFont(new Font("", Font.BOLD, 12));
        cash3.addActionListener(this);
        image.add(cash3);

        cash4 = new JButton("$200");
        cash4.setBounds(437, 298, 150, 30);
        cash4.setFont(new Font("", Font.BOLD, 12));
        cash4.addActionListener(this);
        image.add(cash4);

        cash5 = new JButton("$500");
        cash5.setBounds(225, 339, 150, 30);
        cash5.setFont(new Font("", Font.BOLD, 12));
        cash5.addActionListener(this);
        image.add(cash5);

        cash6 = new JButton("$1000");
        cash6.setBounds(437, 339, 150, 30);
        cash6.setFont(new Font("", Font.BOLD, 12));
        cash6.addActionListener(this);
        image.add(cash6);

        back = new JButton("BACK");
        back.setBounds(437, 380, 150, 30);
        back.setFont(new Font("", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);

        setSize(1024, 805);
        setLocationRelativeTo(null); // this will center the JFrame on the screen
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new transactions(passwordnumber).setVisible(true);

        } else {

            String money = ((JButton) ae.getSource()).getText().substring(1); //$ 1000
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='" + passwordnumber + "'");
                int balance = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(money)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                System.out.println(balance);
                Date date = new Date();
                String query = "insert into bank values('" + passwordnumber + "', '" + date + "', 'Withdrawl', '" + money + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$" + money + " Debited Successfully.");

                setVisible(false);
                new transactions(passwordnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new fastcash("");
    }
}
