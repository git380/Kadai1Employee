package P100.P101.dao;

import A100.dao.DAOParam;
import P100.P101.model.PatientRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO extends DAOParam {
    //DBに接続/自動切断
    /*public Account findByLogin(PatientRegistration patientRegistration) {
        Account account = null;

        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

            // SELECT文を準備
            String sql = "SELECT * FROM patient WHERE patid = ? AND patpasswd = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, patientRegistration.getEmpId());
            pStmt.setString(2, patientRegistration.getEmppasswd());

            // SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();

            // 一致したユーザーが存在した場合
            // そのユーザーを表すAccountインスタンスを生成
            if (rs.next()) {
                // 結果表からデータを取得
                String patid = rs.getString("patid");
                String patfname = rs.getString("patfname");
                String patlname = rs.getString("patlname");
                String patpasswd = rs.getString("patpasswd");
                int patrole = rs.getInt("patrole");
                account = new Account(patid, patfname, patlname, patpasswd, patrole);



                // 取得したデータを出力
                System.out.println("id:" + patid + "patfname:" + patfname + "patlname:" + patlname + "patpasswd:" + patpasswd + "role:" + patrole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        // 見つかったユーザーまたはnullを返す
        return account;
    }*/

    public void insertPatient(PatientRegistration patient) {
        // データベースへ接続
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "INSERT INTO patient (patid, patfname, patlname, hokenmei, hokenexp) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // SQLのDateに変換
            //java.sql.Date sqlDate = new java.sql.Date(patient.getHokenexp().getTime());

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
