package D100.D102.model;

import D100.D102.dao.MedicineDeletionDAO;

public class MedicineDeletionLogic {
    public void deleteMedicine(String medicineId) {
        MedicineDeletionDAO dao = new MedicineDeletionDAO();
        dao.deleteMedicine(medicineId);
    }
}
