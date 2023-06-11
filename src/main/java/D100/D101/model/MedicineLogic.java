package D100.D101.model;

import D100.D101.dao.MedicineDAO;

import java.util.List;

public class MedicineLogic {
    public List<Medicine> getMedicines() {
        MedicineDAO dao = new MedicineDAO();
        return dao.getMedicines();
    }
}
