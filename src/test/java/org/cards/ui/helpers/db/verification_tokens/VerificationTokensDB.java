package org.cards.ui.helpers.db.verification_tokens;

import org.cards.ui.helpers.db.BaseDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.cards.ui.helpers.db.verification_tokens.VerificationTokensNames.*;

public class VerificationTokensDB extends BaseDB {
    private final ArrayList<HashMap<String, Object>> result;

    public VerificationTokensDB() {
        this.result = new ArrayList<>();
    }

    private HashMap<String, Object> insertTableDataToHashMap(ResultSet resultSet) throws SQLException {
        HashMap<String, Object> resultRow = new HashMap<>();
        resultRow.put(ID, resultSet.getInt("id"));
        resultRow.put(ATTEMPT, resultSet.getInt("attempt"));
        resultRow.put(TOKEN, resultSet.getString("token"));
        resultRow.put(USER_ID, resultSet.getString("user_id"));
        resultRow.put(CREATED_AT, resultSet.getTimestamp("created_at"));
        resultRow.put(UPDATED_AT, resultSet.getTimestamp("updated_at"));
        return resultRow;
    }

    public ArrayList<HashMap<String, Object>> getByUserId(String user){
        ResultSet rs = executeScript("SELECT * FROM verification_tokens WHERE id=" + user + ";");
        try {
            while (rs.next()) {
                this.result.add(insertTableDataToHashMap(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;

    }
}
