package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    //global variables
    JRadioButton acc1, acc2, acc3, acc4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, previous;
    String appno;

    SignupThree(String appno) {

        //appno from signuptwo
        this.appno = appno;

        //nimbus looka and feel
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //layout null
        setLayout(null);

        //account details print
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(225, 40, 400, 40);
        add(l1);

        //account type print
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        //Radiobutton
        acc1 = new JRadioButton("Savings Account");
        acc1.setFont(new Font("Raleway", Font.PLAIN, 15));
        acc1.setBackground(Color.WHITE);
        acc1.setBounds(100, 180, 250, 20);
        add(acc1);

        //radiobutton
        acc2 = new JRadioButton("Fixed Deposit Account");
        acc2.setFont(new Font("Raleway", Font.PLAIN, 15));
        acc2.setBackground(Color.WHITE);
        acc2.setBounds(350, 180, 250, 20);
        add(acc2);

        //radiobutton
        acc3 = new JRadioButton("Current Account");
        acc3.setFont(new Font("Raleway", Font.PLAIN, 15));
        acc3.setBackground(Color.WHITE);
        acc3.setBounds(100, 220, 250, 20);
        add(acc3);

        //radiobutton
        acc4 = new JRadioButton("Reccuring Deposit Account");
        acc4.setFont(new Font("Raleway", Font.PLAIN, 15));
        acc4.setBackground(Color.WHITE);
        acc4.setBounds(350, 220, 250, 20);
        add(acc4);

        //group radiobuttons
        ButtonGroup acctype = new ButtonGroup();
        acctype.add(acc1);
        acctype.add(acc2);
        acctype.add(acc3);
        acctype.add(acc4);

        //sample cardno print
        JLabel card = new JLabel("Sample Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 300, 250, 30);
        add(card);

        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-4184");
        cardno.setFont(new Font("Raleway", Font.PLAIN, 19));
        cardno.setBounds(340, 300, 300, 40);
        add(cardno);

        //sample pin print
        JLabel pin = new JLabel("Sample PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway", Font.PLAIN, 19));
        pinno.setBounds(340, 370, 300, 40);
        add(pinno);

        //info print
        JLabel carddetail = new JLabel("Your 16 Digit Card Number:");
        carddetail.setFont(new Font("Raleway", Font.ITALIC, 12));
        carddetail.setBounds(100, 330, 300, 20);
        add(carddetail);

        JLabel pindetail = new JLabel("Your 4 Digit PIN Number:");
        pindetail.setFont(new Font("Raleway", Font.ITALIC, 12));
        pindetail.setBounds(100, 400, 300, 20);
        add(pindetail);

        //services req print
        JLabel services = new JLabel("Services Needed: ");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 460, 250, 30);
        add(services);

        //checkbox output
        c1 = new JCheckBox("Request ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.PLAIN, 15));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        //checkbox output
        c2 = new JCheckBox("Activate Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.PLAIN, 15));
        c2.setBounds(370, 500, 200, 30);
        add(c2);

        //checkbox output
        c3 = new JCheckBox("Register for Mobile App Services");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.PLAIN, 15));
        c3.setBounds(100, 550, 250, 30);
        add(c3);

        //checkbox output
        c4 = new JCheckBox("Subscribe to Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.PLAIN, 15));
        c4.setBounds(370, 550, 200, 30);
        add(c4);

        //checkbox output
        c5 = new JCheckBox("Request for Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.PLAIN, 15));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        //checkbox output
        c6 = new JCheckBox("Enroll for E-Statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.PLAIN, 15));
        c6.setBounds(370, 600, 200, 30);
        add(c6);

        //checkbox output
        c7 = new JCheckBox("I Hereby declare that all details entered are correct and accurate.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 400, 30);
        add(c7);

        //Submit button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(200, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        //cancel button
        previous = new JButton("Cancel");
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Raleway", Font.BOLD, 14));
        previous.setBounds(370, 720, 100, 30);
        previous.addActionListener(this);
        add(previous);

        //content pane
        getContentPane().setBackground(Color.WHITE);
        setSize(700, 820);
        setLocation(350, 30);
        setVisible(true);
    }

    //after clicking button
    public void actionPerformed(ActionEvent ae) {
        
        //if submit button clicked
        if (ae.getSource() == submit) {
            String accounttype = "";

            //save account type
            if (acc1.isSelected()) {
                accounttype = "Savings Account";
            } else if (acc2.isSelected()) {
                accounttype = "Fixed Deposit Account";
            } else if (acc3.isSelected()) {
                accounttype = "Current Account";
            } else if (acc4.isSelected()) {
                accounttype = "Reccuring Deposit Account";
            }

            //random card number save
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L + 5040936000000000L));

            //String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            //accept services
            StringBuilder service = new StringBuilder();
            
            if (c1.isSelected()) {
                service.append("Request ATM Card, ");
            }
            if (c2.isSelected()) {
                service.append("Activate Internet Banking, ");
            }
            if (c3.isSelected()) {
                service.append("Register for Mobile App Services, ");
            }
            if (c4.isSelected()) {
                service.append("Subscribe to Email Alerts, ");
            }
            if (c5.isSelected()) {
                service.append("Request for Cheque Book, ");
            }
            if (c6.isSelected()) {
                service.append("Enroll for E-Statements, ");
            }
           
            //remove ,
if(service.length()!=0)
    service.setLength(service.length()-2);
         
//check if Terms are checked
            String checkbox = "";
            if (c7.isSelected()) {
                checkbox = checkbox + "Agreed";
            }
            
            //try and catch to MYSQL
            try {
                
                //see if all options are clicked
                StringBuilder errors = new StringBuilder();

                if (accounttype.equals("")) {
                    errors.append("Account Type, ");
                }
                if (service.length() == 0) {
                    errors.append("Services Needed, ");
                }

                //if options not clicked, dialog box
                if (errors.length() > 0 || !checkbox.equals("Agreed")) {
                    
                    //dialog box for options not clicked
                    if (errors.length() > 0) {
                        errors.setLength(errors.length() - 2);
                        errors.append(" is required.");
                        JOptionPane.showMessageDialog(null, errors.toString());
                    }
                    
                    //dialog box for terms not clicked
                    if (!checkbox.equals("Agreed")) {
                        JOptionPane.showMessageDialog(null, "CONFIRM the Terms and Conditions");
                    }
                    
                } else {
                    //to accept pin number
                    String pinnumber = JOptionPane.showInputDialog("Enter Your 4 digit Pin Here", "PIN");
                    //check if pin is numbers or not
                    boolean isNumeric = pinnumber.matches("\\d+");
                    
                    //check if pin is 4 digits and numbers both
                    if (isNumeric == true && pinnumber.length() == 4) {
                        
                        //send data to sql (query3 is for cardnumber and pinnumber exclusively)
                        conn c = new conn();
                        String query2 = "insert into signupthree values('" + appno + "','" + accounttype + "','" + cardnumber + "','" + pinnumber + "','" + service + "')";
                        String query3 = "insert into login values('" + appno + "','" + cardnumber + "','" + pinnumber + "')";
                        c.s.executeUpdate(query2);
                        c.s.executeUpdate(query3);
                        System.out.print(query2);
                        //output cardnumber and pin number
                        JOptionPane.showMessageDialog(null, "<html><font size='3'>Card Number: " + cardnumber + "<br>Pin: " + pinnumber + "</font><br><font size='2'>(For Convenience remember only last 4 digits)</font></html>");
                        setVisible(false);
                    } else {
                        
                        //if pin number isnt 4 digits, dialog
                        JOptionPane.showMessageDialog(null, "Please Enter a pin that is 4 digits and has only numbers.");
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        
        //if previous clicked
        if(ae.getSource()==previous){
        setVisible(false);

        }
    } // Closing bracket for actionPerformed method

    public static void main(String args[]) {
        new SignupThree("");
    }
} // Closing bracket for SignupThree class

