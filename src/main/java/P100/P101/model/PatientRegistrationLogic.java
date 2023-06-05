package P100.P101.model;

import P100.P101.dao.PatientDAO;

public class PatientRegistrationLogic {
    /*public boolean execute(PatientRegistration patientRegistration) {
        PatientDAO dao = new PatientDAO();
        Account account = dao.findByLogin(patientRegistration);
        return account != null;
    }*/
    public void newPatient(PatientRegistration patient) {
        PatientDAO dao = new PatientDAO();
        dao.insertPatient(patient);
    }
}