package P100.P105.model;

import P100.P105.dao.PatientSearchDAO;

import java.util.ArrayList;

public class PatientSearchLogic {
    public ArrayList<PatientSearch> searchPatient() {
        PatientSearchDAO dao = new PatientSearchDAO();
        return dao.searchPatient();
    }
}
