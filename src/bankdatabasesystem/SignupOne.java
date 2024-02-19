package bankdatabasesystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nametext, fnametext, emailtext, addtext, citytext, postaltext;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser datechoose;
    JComboBox provinceList;

    SignupOne() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setLayout(null);

        //Generating Random number
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        //Print Form Name
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        //Print Title
        JLabel personaldetails = new JLabel("Page 1: Personal Details ");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290, 80, 400, 30);
        add(personaldetails);

        //Name and Textfield
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Raleway", Font.PLAIN, 14));
        nametext.setBounds(300, 140, 400, 30);
        add(nametext);

        //Fathers Name and Textfield
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnametext = new JTextField();
        fnametext.setFont(new Font("Raleway", Font.PLAIN, 14));
        fnametext.setBounds(300, 190, 400, 30);
        add(fnametext);

        //Date of Birth and JCalendar
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        datechoose = new JDateChooser();
        datechoose.setBounds(300, 240, 400, 30);
        datechoose.setForeground(new Color(105, 105, 105));
        add(datechoose);

        //Gender and Radiobutton
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        //Male
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        //Female
        female = new JRadioButton("Female");
        female.setBounds(400, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        //Group Male and Female
        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);

        //Email and Textfield
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailtext = new JTextField();
        emailtext.setFont(new Font("Raleway", Font.PLAIN, 14));
        emailtext.setBounds(300, 340, 400, 30);
        add(emailtext);

        //Marital Status and Radiobutton
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        //Married Radiobutton
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        //Unmarried Radiobutton
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        //Other Radiobutton
        other = new JRadioButton("Other");
        other.setBounds(518, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        //Group Unmarried, Married and Other Radiobuttons
        ButtonGroup maritalgrp = new ButtonGroup();
        maritalgrp.add(married);
        maritalgrp.add(unmarried);
        maritalgrp.add(other);

        //Address and Textfield
        JLabel add = new JLabel("Address");
        add.setFont(new Font("Raleway", Font.BOLD, 20));
        add.setBounds(100, 440, 200, 30);
        add(add);

        addtext = new JTextField();
        addtext.setFont(new Font("Raleway", Font.PLAIN, 14));
        addtext.setBounds(300, 440, 400, 30);
        add(addtext);

        //City and Textfield
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        citytext = new JTextField();
        citytext.setFont(new Font("Raleway", Font.PLAIN, 14));
        citytext.setBounds(300, 490, 400, 30);
        add(citytext);

        //Province and JCombobox
        JLabel prov = new JLabel("Province:");
        prov.setFont(new Font("Raleway", Font.BOLD, 20));
        prov.setBounds(100, 540, 200, 30);
        add(prov);

        // Create a JComboBox and add the array to it
        String[] provinces = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan"};
        provinceList = new JComboBox(provinces);
        provinceList.setFont(new Font("Raleway", Font.PLAIN, 14));
        provinceList.setBounds(300, 540, 400, 30);
        add(provinceList);

        //Postal Code and Textfield
        JLabel postal = new JLabel("Postal Code:");
        postal.setFont(new Font("Raleway", Font.BOLD, 20));
        postal.setBounds(100, 590, 200, 30);
        add(postal);

        postaltext = new JTextField();
        postaltext.setFont(new Font("Raleway", Font.PLAIN, 14));
        postaltext.setBounds(300, 590, 400, 30);
        add(postaltext);

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

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;//long

        String province = provinceList.getSelectedItem().toString();

        String name = nametext.getText(); //settext change text, get text extract text
        String email = emailtext.getText();
        String city = citytext.getText();
        String postal = postaltext.getText();
        String address = addtext.getText();
        String fname = fnametext.getText();
        String dob = ((JTextField) datechoose.getDateEditor().getUiComponent()).getText();

        //Gender radiobutton
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        //marital radiobutton
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else {
            marital = "Other";
        }

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                conn c = new conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + postal + "', '" + province + "')";
                c.s.executeUpdate(query);
                System.out.print(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {

        new SignupOne();
      
    }
}
