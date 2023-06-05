package P100.P102.dao;

import A100.dao.DAOParam;
import P100.P102.model.PatientUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientUpdateDAO extends DAOParam {
    public void updatePatient(PatientUpdate patient) {// データベースへ接続
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "UPDATE patient SET hokenmei = ?, hokenexp = ? WHERE patid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // パラメータの設定
            preparedStatement.setString(1, patient.getHokenmei());
            preparedStatement.setString(2, patient.getHokenexp());
            preparedStatement.setString(3, patient.getPatid());

            // SQL実行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
