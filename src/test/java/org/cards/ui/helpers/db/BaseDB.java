package org.cards.ui.helpers.db;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDB {

    protected ResultSet executeScript(String sql) {
        String url = "jdbc:mysql://127.0.0.1:3306/cards";
        String user = "user";
        String password = "pass";
        ResultSet result = null;
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            result = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
