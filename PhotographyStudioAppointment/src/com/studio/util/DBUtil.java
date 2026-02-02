package com.studio.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getDBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "studio";
            String pass = "studio123";
            Connection con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
