package P100.P102.model;

import P100.P102.dao.PatientDAO;

public class PatientRegistrationLogic {
    public void updatePatient(PatientRegistration patientRegistration) {
        PatientDAO dao = new PatientDAO();
        dao.updatePatient(patientRegistration);
    }
}