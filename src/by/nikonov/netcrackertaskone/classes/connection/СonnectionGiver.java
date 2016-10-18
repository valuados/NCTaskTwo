package by.nikonov.netcrackertaskone.classes.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by valua on 10/13/2016.
 */
public class СonnectionGiver {
    public static final String URL="jdbc:mysql://localhost:3306/stone";
    //"jdbc:sqlite:E:/My Programms/Netcracker/TaskTwo/web/db/database.db";
    public static final String USER="root";
    public static final String PASS="";

    private static СonnectionGiver instance = new СonnectionGiver();

    public СonnectionGiver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("couldn't find Driver. exiting");
            System.exit(1);
        }
    }

    public static СonnectionGiver getInstance() {
        return instance;
    }

    public Connection getConnection() {
        Connection cnt = null;
        try {
            cnt = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            System.err.println("couldn't create a connection. exiting" + ex);
            System.exit(1);
        }
        return cnt;
    }

}
