package P100.P104.dao;

import A100.dao.DAOParam;
import P100.P104.model.PatientExpiration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientExpirationDAO extends DAOParam {
    // 保険証の有効期限が過ぎた患者を取得するメソッド
    public List<PatientExpiration> getExpiredInsurancePatients() {
        List<PatientExpiration> expiredPatients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // 現在の日付を取得
            java.util.Date currentDate = new java.util.Date();

            // SQL文の準備
            String sql = "SELECT * FROM patient WHERE insurance_exp < ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // パラメータの設定
            preparedStatement.setDate(1, new java.sql.Date(currentDate.getTime()));

            // SQL実行し、結果を取得
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 取得した結果から患者情報を作成し、リストに追加
                String patid = resultSet.getString("patid");
                String patfname = resultSet.getString("patfname");
                String patlname = resultSet.getString("patlname");
                String hokenmei = resultSet.getString("hokenmei");
                String hokenexp = resultSet.getString("hokenexp");

                PatientExpiration patient = new PatientExpiration(patid, patfname, patlname, hokenmei, hokenexp);

                System.out.println(patid + " " + patfname + " " + patlname + " " + hokenmei + " " + hokenexp);

                expiredPatients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 有効期限が過ぎた患者のリストを返す
        return expiredPatients;
    }
}