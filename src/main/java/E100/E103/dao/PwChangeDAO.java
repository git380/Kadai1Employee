package E100.E103.dao;

import A100.dao.DAOParam;
import L100.L101.hash.SaltUserPassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PwChangeDAO extends DAOParam {

    public void passwordChange(String empId, String empPasswd) {
        // データベースへ接続
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE employee SET emppasswd = ? WHERE empid = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, new SaltUserPassword().getDigest(empId, empPasswd));
            statement.setString(2, empId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
