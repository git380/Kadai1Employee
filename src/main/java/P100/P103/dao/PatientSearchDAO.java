package P100.P103.dao;

import A100.dao.DAOParam;
import P100.P103.model.PatientSearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientSearchDAO extends DAOParam {
    // 患者を検索するメソッド
    public List<PatientSearch> searchPatient(String patfname, String patlname) {
        List<PatientSearch> patients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "SELECT * FROM patient WHERE patfname = ? AND patlname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // パラメータの設定
            preparedStatement.setString(1, patfname);
            preparedStatement.setString(2, patlname);

            // SQL実行し、結果を取得
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 取得した結果から患者情報を作成し、リストに追加
                String patid = resultSet.getString("patid");
                //String patfname = resultSet.getString("patfname");
                //String patlname = resultSet.getString("patlname");
                String hokenmei = resultSet.getString("hokenmei");
                String hokenexp = resultSet.getString("hokenexp");

                PatientSearch patient = new PatientSearch(patid, patfname, patlname, hokenmei, hokenexp);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 検索結果のリストを返す
        return patients;
    }
}
