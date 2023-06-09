package P100.P105.model;

import P100.P105.dao.PatientSearchDAO;

import java.util.List;

public class PatientSearchLogic {
    public List<PatientSearch> searchPatient() {
        PatientSearchDAO dao = new PatientSearchDAO();
        return dao.searchPatient();
    }
}
