package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.*;

public class transactions extends JFrame implements ActionListener {

    JButton deposit, withdraw, pinchange, exit, fastcash, balanceenq, ministate;
    String passwordnumber;

    transactions(String passwordnumber) {
        this.passwordnumber = passwordnumber;
        setLayout(null);

        /*nimbus looka and feel
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2); // corrected line
        JLabel image = new JLabel(i3); // set the ImageIcon to the JLabel
        image.setBounds(0, 0, 1024, 768);
        add(image);

        JLabel text = new JLabel("Please Select");
        text.setBounds(360, 150, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel text1 = new JLabel("Your Transaction");
        text1.setBounds(345, 175, 700, 35);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System", Font.BOLD, 16));
        image.add(text1);

        deposit = new JButton("Deposit");
        deposit.setBounds(225, 255, 150, 30);
        deposit.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(437, 255, 150, 30);
        withdraw.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(225, 298, 150, 30);
        fastcash.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministate = new JButton("Mini Statement");
        ministate.setBounds(437, 298, 150, 30);
        ministate.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        ministate.addActionListener(this);
        image.add(ministate);

        pinchange = new JButton("PIN Change");
        pinchange.setBounds(225, 339, 150, 30);
        pinchange.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenq = new JButton("Balance Enquiry");
        balanceenq.setBounds(437, 339, 150, 30);
        balanceenq.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        balanceenq.addActionListener(this);
        image.add(balanceenq);

        exit = new JButton("Exit");
        exit.setBounds(437, 380, 150, 30);
        exit.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
        exit.addActionListener(this);
        image.add(exit);

        setSize(1024, 805);
        setLocationRelativeTo(null); // this will center the JFrame on the screen
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            setVisible(false);
            new deposit(passwordnumber).setVisible(true);
        }

        if (ae.getSource() == withdraw) {
            setVisible(false);
            new withdrawl(passwordnumber).setVisible(true);
        }

        if (ae.getSource() == fastcash) {
            setVisible(false);
            new fastcash(passwordnumber).setVisible(true);
        }

        if (ae.getSource() == ministate) {
            new ministatement(passwordnumber).setVisible(true);
        }

        if (ae.getSource() == pinchange) {
            setVisible(false);
            new pinchange(passwordnumber).setVisible(true);
        }

        if (ae.getSource() == balanceenq) {
            setVisible(false);
            new balanceenquiry(passwordnumber).setVisible(true);
        }

        if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new transactions("");
    }
}
