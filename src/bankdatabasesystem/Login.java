//IMPLEMENT LUHNS ALGORTHIM login() if(cardnumber != luhns) sysout "Invalid"
package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    //globally define variables
    JButton login, clear, signup;
    JTextField cardnotext;
    JPasswordField passtext;

    Login() {

        //Nimbus Look 
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("ATM Login");

        setLayout(null);

        //adding image and setting bounds
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmte.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(110, 50, 100, 100);
        add(label);

        //Welcome to atm text and setting bounds
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(240, 60, 300, 100);
        add(text);

        //adding card number text and setting bounds
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 23));
        cardno.setBounds(50, 230, 180, 30);
        add(cardno);

        //adding password text and setting bounds
        JLabel pin = new JLabel("Password:");
        pin.setFont(new Font("Raleway", Font.BOLD, 23));
        pin.setBounds(50, 310, 170, 30);
        add(pin);

        //adding password text box and setting bounds
        passtext = new JPasswordField();
        passtext.setBounds(230, 310, 230, 30);
        passtext.setFont(new Font("Arial", Font.PLAIN, 14));
        add(passtext);

        //adding card number text box and setting bounds
        cardnotext = new JTextField();
        cardnotext.setBounds(230, 230, 230, 30);
        cardnotext.setFont(new Font("Arial", Font.PLAIN, 14));
        add(cardnotext);

        //Login button and setting bounds
        login = new JButton("LOGIN");
        login.setBounds(230, 380, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); //make button work
        add(login);

        //Clear button and setting bounds
        clear = new JButton("CLEAR");
        clear.setBounds(360, 380, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this); //make button work
        add(clear);

        //signup button and setting bounds
        signup = new JButton("SIGNUP");
        signup.setBounds(230, 430, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this); //make button work
        add(signup);

        //background color
        getContentPane().setBackground(Color.WHITE);

        //window size
        setSize(600, 560);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    //main method for actions on button
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardnotext.setText("");
            passtext.setText("");

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);

        } else if (ae.getSource() == login) {
            conn c = new conn();
            String passwordnumber = passtext.getText();
            String cardnumber = cardnotext.getText();
            String query = "select * from login where RIGHT(card_number, 4) = '" + cardnumber + "' and pin_number = '" + passwordnumber + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new transactions(passwordnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        }
    }

    //main main method
    public static void main(String args[]) {
        new Login();

    }
}
