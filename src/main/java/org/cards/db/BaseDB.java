package org.cards.db;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDB {
    protected int userId;
    private final String url = "jdbc:mysql://127.0.0.1:3306/cards";
    private final String user = "user";
    private final String password = "pass";

    public BaseDB(String email) {
        getUserIdByEmail(email);
    }

    private void getUserIdByEmail(String email) {
        String query = "SELECT * FROM users WHERE email='" + email + "';";
        ResultSet rs = executeGet(query);
        try {
            if (rs.next()) {
                userId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public ResultSet executeGet(String sql) {
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

    public void executeUpdate(String sql) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
