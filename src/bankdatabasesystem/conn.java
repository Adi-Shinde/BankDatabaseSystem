package bankdatabasesystem;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    public conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystemDB", "root", "Sonamona0*"); //"jdbc:mysql://localhost:3306" but localhost:3306 is default so not needed
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
/*
*/