package E100.E103.model;

import E100.E103.dao.PwChangeDAO;

public class PwChangeLogic {

    public void empPasswd(String empId, String empPasswd) {
        PwChangeDAO dao = new PwChangeDAO();
        dao.passwordChange(empId, empPasswd);
    }
}
