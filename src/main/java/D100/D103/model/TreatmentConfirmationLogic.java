package D100.D103.model;

import D100.D103.dao.TreatmentConfirmationDAO;

public class TreatmentConfirmationLogic {
    public void confirmTreatment() {
        TreatmentConfirmationDAO dao = new TreatmentConfirmationDAO();
        dao.confirmTreatment();
    }
}
