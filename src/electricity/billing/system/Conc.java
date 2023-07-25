package electricity.billing.system;

import java.sql.*;

public class Conc {

    Connection c;
    Statement s;
    Conc() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebs","root", "Priyanka8.");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();//tool to handle exceptions and errors
        }
    }
}