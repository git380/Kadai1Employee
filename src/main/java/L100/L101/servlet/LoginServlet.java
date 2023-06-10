package L100.L101.servlet;

import A100.model.Account;
import L100.L101.model.Login;
import L100.L101.model.LoginLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/L100/L101/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String empId = request.getParameter("empId");
        String empPasswd = request.getParameter("empPasswd");

        // ログイン処理の実行
        Login login = new Login(empId, empPasswd);
        LoginLogic bo = new LoginLogic();
        Account result = bo.execute(login);

        // ログイン処理の成否によって処理を分岐
        if (result != null) { // ログイン成功時
            // セッションスコープにユーザーID従業員情報を保存
            HttpSession session = request.getSession();
            session.setAttribute("empId", empId);
            session.setAttribute("emprole", result.getEmpRole());

            // フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/L100/L101/loginOK.jsp");
            dispatcher.forward(request, response);
        } else { // ログイン失敗時
            // フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/L100/L101/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}