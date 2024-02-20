package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    //Global Variables
    JTextField secqstext, sintext;
    JButton next;
    JRadioButton sno, syes, eno, eyes;
    JComboBox secqslist, edulist, incomelist, occlist;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        //Nimbus look and feel
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        //Print Title
        JLabel additionaldetails = new JLabel("Page 2: Additional Details ");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(280, 80, 400, 30);
        add(additionaldetails);

        //Security Question
        JLabel secqs = new JLabel("Choose a");
        JLabel secqs1 = new JLabel("Security Question:");
        secqs.setFont(new Font("Raleway", Font.BOLD, 20));
        secqs1.setFont(new Font("Raleway", Font.BOLD, 20));
        secqs.setBounds(100, 200, 120, 30);
        secqs1.setBounds(100, 220, 200, 30);
        add(secqs);
        add(secqs1);

        // Options for security questions
        String[] secqsarray = {"", "What city were you born in?", "What is the name of your first pet?", "What is your mother's maiden name?", "What was the first concert you attended?", "What is the name of your favourite childhood friend?", "What was your first car?", "What is the name of the street you grew up in?"};
        secqslist = new JComboBox(secqsarray);
        secqslist.setFont(new Font("Raleway", Font.PLAIN, 14));
        secqslist.setBounds(300, 190, 400, 30);
        add(secqslist);

        //Entering Security Question
        secqstext = new JTextField();
        secqstext.setFont(new Font("Raleway", Font.PLAIN, 14));
        secqstext.setBounds(300, 230, 400, 30);
        add(secqstext);

        //Educational Qualifications Output
        JLabel eduqual = new JLabel("Educational");
        eduqual.setFont(new Font("Raleway", Font.BOLD, 20));
        eduqual.setBounds(100, 280, 200, 30);
        add(eduqual);
        //Gender and Radiobutton
        JLabel eduqual1 = new JLabel("Qualification:");
        eduqual1.setFont(new Font("Raleway", Font.BOLD, 20));
        eduqual1.setBounds(100, 300, 200, 30);
        add(eduqual1);

        // Create a JComboBox and add the array to it
        String[] eduarray = {"", "High-School Diploma (HSD) ", "College Degree", "Bachelors or Under-Graduate Degree (BA,BS) ", "Post-Graduate/Masters Degree (MA,MS) ", "Doctorate Degree (PH.D.) D", "Other"};
        edulist = new JComboBox(eduarray);
        edulist.setFont(new Font("Raleway", Font.PLAIN, 14));
        edulist.setBounds(300, 290, 400, 30);
        add(edulist);

        //Income output
        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 360, 200, 30);
        add(inc);

        // Create a JComboBox and add the array to it
        String[] incomearray = {"", "< $50,000", "< $75,000", "< $90,000 ", "< $120,000 ", "< $150,000 ", "< $180,000 ", "> $200,000"};
        incomelist = new JComboBox(incomearray);
        incomelist.setFont(new Font("Raleway", Font.PLAIN, 14));
        incomelist.setBounds(300, 360, 400, 30);
        add(incomelist);

        //Occupation Output
        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 430, 200, 30);
        add(occ);

        // Create a JComboBox and add the array to it
        String[] occarray = {"", "Self-Employed", "Salaried", "Business ", "Student ", "Retired ", "Other "};
        occlist = new JComboBox(occarray);
        occlist.setFont(new Font("Raleway", Font.PLAIN, 14));
        occlist.setBounds(300, 430, 400, 30);
        add(occlist);

        //Sin Number Output and Textfield
        JLabel sin = new JLabel("Sin Number:");
        sin.setFont(new Font("Raleway", Font.BOLD, 20));
        sin.setBounds(100, 490, 200, 30);
        add(sin);

        sintext = new JTextField();
        sintext.setFont(new Font("Raleway", Font.PLAIN, 14));
        sintext.setBounds(300, 490, 400, 30);
        add(sintext);

        //Senior Citizen Output
        JLabel snr = new JLabel("Senior Citizen:");
        snr.setFont(new Font("Raleway", Font.BOLD, 20));
        snr.setBounds(100, 550, 200, 30);
        add(snr);

        //JRadioButton for Senior Citizen
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 550, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(400, 550, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        //Group Yes and No for Senior Citizen
        ButtonGroup snrcit = new ButtonGroup();
        snrcit.add(syes);
        snrcit.add(sno);

        //Existing Account Output
        JLabel exist = new JLabel("Existing Account:");
        exist.setFont(new Font("Raleway", Font.BOLD, 20));
        exist.setBounds(100, 600, 200, 30);
        add(exist);

        //JRadioButton for Existing Account
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 600, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400, 600, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        //Group Yes and No for Existing accounts
        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(eyes);
        gendergrp.add(eno);

        //Next button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        //Content Pane
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    //action to be performed after clicking button
    public void actionPerformed(ActionEvent ae) {

        //convert all data to string to store from textfields
        String securityquestions = (String) secqslist.getSelectedItem();
        String securityanswers = secqstext.getText();
        String educationalqualifications = (String) edulist.getSelectedItem();
        String income = (String) incomelist.getSelectedItem();
        String occupation = (String) occlist.getSelectedItem();
        String sinnumber = sintext.getText();
        //convert data to string from Senior Citizen radiobutton
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        //convert data to string from existing account radiobutton
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        //try and catch 
        try {

            StringBuilder errors = new StringBuilder();
            if (securityquestions.equals("")) {
                errors.append("Security Question, ");
            }
            if (securityanswers.equals("")) {
                errors.append("Security Answer, ");
            }
            if (educationalqualifications.equals("")) {
                errors.append("Educational Qualifications ");
            }
            if (income.equals("")) {
                errors.append("Income, ");
            }
            if (occupation.equals("")) {
                errors.append("Occupation, ");
            }
            if (sinnumber.equals("")) {
                errors.append("Sin Number, ");
            }
            if (seniorcitizen == null) {
                errors.append("Senior Citizen, ");
            }
            if (existingaccount == null) {
                errors.append("Existing Account, ");
            }

            //if all data is not entered output dialog box
            if (errors.length() > 0) {
                errors.setLength(errors.length() - 2);
                errors.append(" is required.");
                JOptionPane.showMessageDialog(null, errors.toString());
                //if data entered, store in database
            } else {
                conn c = new conn();
                String query = "insert into signuptwo values('" + formno + "', '" + securityquestions + "', '" + securityanswers + "', '" + educationalqualifications + "', '" + income + "', '" + occupation + "', '" + sinnumber + "', '" + seniorcitizen + "', '" + existingaccount + "')";
                c.s.executeUpdate(query);
                System.out.print(query);
                setVisible(false);
            }
            //signup3 object
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {

        new SignupTwo("");

    }
}
