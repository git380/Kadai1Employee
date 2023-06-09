package D100.D103.model;

public class TreatmentConfirmation {
    private String patId;
    private String medicineId;
    private int quantity;
    private String impDate;

    public TreatmentConfirmation(String patId, String medicineId, int quantity, String impDate) {
        this.patId = patId;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.impDate = impDate;
    }

    public String getPatId() {
        return patId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImpDate() {
        return impDate;
    }
}
