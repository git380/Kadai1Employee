package D100.D101.dao;

import A100.dao.DAOParam;
import D100.D101.model.Medicine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineDAO extends DAOParam {
    public ArrayList<Medicine> getMedicines() {
        ArrayList<Medicine> medicines = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // SQL文の準備
            String sql = "SELECT * FROM medicine";
            PreparedStatement statement = connection.prepareStatement(sql);

            // SQL実行し、結果を取得
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // 取得した結果から薬剤を追加
                String medicineId = resultSet.getString("medicineid");
                String medicineName = resultSet.getString("medicinename");
                String unit = resultSet.getString("unit");

                Medicine medicine = new Medicine(medicineId, medicineName, unit);
                medicines.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicines;
    }
}
