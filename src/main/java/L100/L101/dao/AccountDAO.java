package L100.L101.dao;

import A100.dao.DAOParam;
import A100.model.Account;
import L100.L101.model.Login;

import java.sql.*;

public class AccountDAO extends DAOParam {
    //DBに接続/自動切断
    public Account findByLogin(Login login) {
        Account account = null;
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

            // SELECT文を準備
            String sql = "SELECT * FROM employee WHERE empid = ? AND emppasswd = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login.getEmpId());
            pStmt.setString(2, login.getEmppasswd());

            // SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();

            // 一致したユーザーが存在した場合
            // そのユーザーを表すAccountインスタンスを生成
            if (rs.next()) {
                // 結果表からデータを取得
                String empid = rs.getString("empid");
                String empfname = rs.getString("empfname");
                String emplname = rs.getString("emplname");
                String emppasswd = rs.getString("emppasswd");
                int emprole = rs.getInt("emprole");
                account = new Account(empid, empfname, emplname, emppasswd, emprole);

                // 取得したデータを出力
                System.out.println("id:" + empid + "empfname:" + empfname + "emplname:" + emplname + "emppasswd:" + emppasswd + "role:" + emprole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        // 見つかったユーザーまたはnullを返す
        return account;
    }

    public void passwordChange(String empId, String emPpasswd) {
        // データベースへ接続
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE employee SET emppasswd = ? WHERE empid = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emPpasswd);
            statement.setString(2, empId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
