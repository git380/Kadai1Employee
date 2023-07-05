package C100.C101.model;

import A100.model.Account;
import C100.C101.dao.ChatDAO;

public class ChatLogic {
    public Account findByEmpId(String empId) {
        ChatDAO dao = new ChatDAO();
        return dao.findByEmpId(empId);
    }
}
