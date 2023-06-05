package P100.P103.model;

import P100.P103.dao.PatientSearchDAO;

import java.util.List;

public class PatientSearchLogic {
    public void searchPatient(PatientSearch patientUpdate) {
        PatientSearchDAO dao = new PatientSearchDAO();
        List<PatientSearch> patient = dao.searchPatients(patientUpdate);
    }
}
