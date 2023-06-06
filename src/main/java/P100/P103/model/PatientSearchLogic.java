package P100.P103.model;

import P100.P103.dao.PatientSearchDAO;

import java.util.List;

public class PatientSearchLogic {
    public List<PatientSearch> searchPatient(String patfname, String patlname) {
        PatientSearchDAO dao = new PatientSearchDAO();
        return dao.searchPatient(patfname, patlname);
    }
}
