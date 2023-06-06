package P100.P101.model;

import P100.P101.dao.PatientDAO;

public class PatientRegistrationLogic {
    public void newPatient(PatientRegistration patient) {
        PatientDAO dao = new PatientDAO();
        dao.insertPatient(patient);
    }
}