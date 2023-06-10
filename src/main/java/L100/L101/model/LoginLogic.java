package L100.L101.model;

import A100.model.Account;
import L100.L101.dao.AccountDAO;

public class LoginLogic {
    public Account execute(Login login) {
        AccountDAO dao = new AccountDAO();
        Account account = dao.findByLogin(login);
        return account;
    }

    public void emPpasswd(String empId, String emPpasswd) {
        AccountDAO dao = new AccountDAO();
        dao.passwordChange(empId, emPpasswd);
    }
}