package P100.P102.model;

import P100.P102.dao.PatientUpdateDAO;

public class PatientUpdateLogic {
    public void updatePatient(PatientUpdate patientUpdate) {
        PatientUpdateDAO dao = new PatientUpdateDAO();
        dao.updatePatient(patientUpdate);
    }
}