package D100.D101.dao;

import A100.dao.DAOParam;
import D100.D101.model.Medicine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO extends DAOParam {
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM medicine";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
