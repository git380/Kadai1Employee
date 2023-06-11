package P100.P102.model;

import P100.P102.dao.PatientUpdateDAO;
import P100.P105.dao.PatientSearchDAO;
import P100.P105.model.PatientSearch;

import java.util.ArrayList;

public class PatientUpdateLogic {
    public ArrayList<PatientSearch> allPatient() {
        PatientSearchDAO dao = new PatientSearchDAO();
        return dao.searchPatient();
    }
    public void updatePatient(PatientUpdate patientUpdate) {
        PatientUpdateDAO dao = new PatientUpdateDAO();
        dao.updatePatient(patientUpdate);
    }
}