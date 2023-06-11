package D100.D101.model;

import java.io.Serializable;

public class Medicine implements Serializable {
    private String medicineId;
    private String medicineName;
    private String unit;

    public Medicine(String medicineId, String medicineName, String unit) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.unit = unit;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getUnit() {
        return unit;
    }
}
