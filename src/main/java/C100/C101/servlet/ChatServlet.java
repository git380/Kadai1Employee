package C100.C101.servlet;

import A100.model.Account;
import C100.C101.model.ChatLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションスコープからユーザーIDを取得
        String empId = (String) request.getSession().getAttribute("empId");

        // ユーザーIDがない場合
        if (empId == null) {
            // ログイペレイト
            response.sendRedirect("WelcomeServlet");
            return;
        }

        ChatLogic chatLogic = new ChatLogic();
        Account chat = chatLogic.findByEmpId(empId);

        String name = chat.getEmpLName() + chat.getEmpFName();

        String role;
        if ((int) request.getSession().getAttribute("emprole") == 1) {
            role = "受付";
        } else {
            role = "医師";
        }

        request.setAttribute("name", name);
        request.setAttribute("role", role);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/C100/C101/chat.jsp");
        dispatcher.forward(request, response);
    }
}
