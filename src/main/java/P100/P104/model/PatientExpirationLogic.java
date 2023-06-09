package P100.P104.model;

import P100.P104.dao.PatientExpirationDAO;

import java.util.List;

public class PatientExpirationLogic {
    public List<PatientExpiration> searchExpired() {
        PatientExpirationDAO dao = new PatientExpirationDAO();
        return dao.getExpiredInsurancePatients();
    }
}