package org.cards.ui.helpers.db.verification_tokens;

import org.cards.ui.helpers.db.BaseDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import static org.cards.ui.helpers.db.verification_tokens.VerificationTokensNames.*;

public class VerificationTokensDB extends BaseDB {

    public VerificationTokensDB(String email) {
        super(email);
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

    public String getToken(){
        String  result = null;
        ResultSet rs = executeScript("SELECT * FROM verification_tokens WHERE id=" + userId + ";");
        try {
            result = rs.getString(TOKEN);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
