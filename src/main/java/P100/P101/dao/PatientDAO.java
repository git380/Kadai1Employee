package P100.P101.dao;

import A100.dao.DAOParam;
import P100.P101.model.PatientRegistration;

import java.sql.*;

public class PatientDAO extends DAOParam {
    // 患者を検索するメソッド
    public boolean nullPatient(String patid) {
        String patSQLId = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "SELECT * FROM patient WHERE patid = ?";
            PreparedStatement pStmt = connection.prepareStatement(sql);
            pStmt.setString(1, patid);

            // SELECTを実行し、結果表を取得
            ResultSet resultSet = pStmt.executeQuery();
            if (resultSet.next()) {
                // 取得した結果を追加
                patSQLId = resultSet.getString("patid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 検索結果のリストを返す
        return patSQLId == null;
    }
    public void insertPatient(PatientRegistration patient) {
        // データベースへ接続
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "INSERT INTO patient (patid, patfname, patlname, hokenmei, hokenexp) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // パラメータの設定
            preparedStatement.setString(1, patient.getPatid());
            preparedStatement.setString(2, patient.getPatfname());
            preparedStatement.setString(3, patient.getPatlname());
            preparedStatement.setString(4, patient.getHokenmei());
            preparedStatement.setString(5, patient.getHokenexp());

            // SQL実行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
