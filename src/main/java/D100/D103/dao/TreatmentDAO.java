package D100.D103.dao;

import A100.dao.DAOParam;
import D100.D103.model.TreatmentConfirmation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TreatmentDAO extends DAOParam {
    public void confirmTreatment(TreatmentConfirmation treatment) {
        // データベースへ接続
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO treatment (patid, medicineid, quantity, impdate) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, treatment.getPatId());
            statement.setString(2, treatment.getMedicineId());
            statement.setInt(3, treatment.getQuantity());
            statement.setString(4, treatment.getImpDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
