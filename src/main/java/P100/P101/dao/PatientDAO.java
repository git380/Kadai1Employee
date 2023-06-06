package P100.P101.dao;

import A100.dao.DAOParam;
import P100.P101.model.PatientRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO extends DAOParam {
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
