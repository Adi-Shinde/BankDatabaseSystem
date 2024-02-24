package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String passwordnumber;

    withdrawl(String passwordnumber) {
        this.passwordnumber = passwordnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2); // corrected line
        JLabel image = new JLabel(i3); // set the ImageIcon to the JLabel
        image.setBounds(0, 0, 1024, 768);
        add(image);

        JLabel text = new JLabel("Please select");
        text.setBounds(360, 150, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel text1 = new JLabel("the amount to withdraw.");
        text1.setBounds(320, 175, 700, 35);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System", Font.BOLD, 16));
        image.add(text1);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(245, 220, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(225, 380, 150, 30);
        withdraw.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(437, 380, 150, 30);
        back.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        back.addActionListener(this);
        image.add(back);

        JLabel bal = new JLabel();
        bal.setFont(new Font("", Font.BOLD|Font.ITALIC, 14));
        bal.setForeground(Color.WHITE);
        bal.setBounds(280, 300, 400, 30);
        image.add(bal);
        
        try {
            conn c1 = new conn();
            int balance = 0;
            ResultSet rs1 = c1.s.executeQuery("select * from bank where pinnumber= '" + passwordnumber + "'");
            while (rs1.next()) {

                if (rs1.getString("type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs1.getString("amount"));
                } else {
                    balance = balance - Integer.parseInt(rs1.getString("amount"));
                }
            }
            bal.setText("Your Current Account Balance is $" + balance);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        setSize(1024, 805);
        setLocationRelativeTo(null); // this will center the JFrame on the screen
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == withdraw) {
            String money = amount.getText();
            Date date = new Date();
            if (money.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to Withdraw");
            } else {
                try {
                    conn c = new conn();

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
             
                
                    
                    String query = "insert into bank values('" + passwordnumber + "', '" + date + "','Withdrawl','" + money + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$" + money + " withdrawed successfully.");
                    setVisible(false);
                    new transactions(passwordnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        if (ae.getSource() == back) {
            setVisible(false);
            new transactions(passwordnumber).setVisible(true);
        }

    }

    public static void main(String args[]) {
        new withdrawl("");
    }
}
