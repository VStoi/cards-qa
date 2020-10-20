package org.cards.ui.helpers.db;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDB {
    protected int userId;

    public BaseDB(String email) {
        getUserIdByEmail(email);
    }

    protected ResultSet executeScript(String sql) {
        String url = "jdbc:mysql://127.0.0.1:3306/cards";
        String user = "user";
        String password = "pass";
        ResultSet result = null;
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            result = pst.executeQuery();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private void getUserIdByEmail(String email) {
        ResultSet rs = executeScript("SELECT id FROM cards.users WHERE email=" + email + ";");
        try {
            userId = rs.getInt("id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
