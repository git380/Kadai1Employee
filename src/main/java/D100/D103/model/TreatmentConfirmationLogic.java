package D100.D103.model;

import D100.D103.dao.TreatmentDAO;

public class TreatmentConfirmationLogic {
    public void newTreatment(TreatmentConfirmation treatmentConfirmation) {
        TreatmentDAO dao = new TreatmentDAO();
        dao.confirmTreatment(treatmentConfirmation);
    }
}
