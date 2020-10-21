package org.cards.ui.helpers.db.users;

import org.cards.ui.helpers.db.BaseDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.cards.ui.helpers.db.users.UserDbNames.*;

public class UsersDb extends BaseDB {
    public UsersDb(String email) {
        super(email);
    }

    private HashMap<String, Object> insertTableDataToHashMap(ResultSet resultSet) throws SQLException {
        HashMap<String, Object> resultRow = new HashMap<>();
        resultRow.put(ID, resultSet.getInt(ID));
        resultRow.put(FIRST_NAME, resultSet.getInt(FIRST_NAME));
        resultRow.put(LAST_NAME, resultSet.getString(LAST_NAME));
        resultRow.put(EMAIL, resultSet.getString(EMAIL));
        resultRow.put(PASSWORD, resultSet.getTimestamp(PASSWORD));
        resultRow.put(BIO, resultSet.getTimestamp(BIO));
        resultRow.put(IS_VERIFIED, resultSet.getTimestamp(IS_VERIFIED));
        resultRow.put(URL, resultSet.getTimestamp(URL));
        resultRow.put(CARDS_COUNT, resultSet.getTimestamp(CARDS_COUNT));
        resultRow.put(ADDRESS, resultSet.getTimestamp(ADDRESS));
        return resultRow;
    }

    public ArrayList<HashMap<String, Object>> getFullData() {
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        ResultSet rs = executeGet("SELECT * FROM users WHERE id=" + userId + ";");
        try {
            while (rs.next()) {
                result.add(insertTableDataToHashMap(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean isVerified() {
        boolean isVerified = false;
        ResultSet rs = executeGet("SELECT * FROM users WHERE id=" + userId + ";");
        try {
            while (rs.next()) {
                if (rs.getInt(IS_VERIFIED) == 1) {
                    isVerified = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isVerified;
    }

    public void setVerified() {
        String query = "UPDATE users SET is_verified=1 WHERE id=" + userId + ";";
        executeUpdate(query);
    }
}
