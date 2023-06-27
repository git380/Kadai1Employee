package A100.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションスコープからユーザーIDを取得
        if (request.getSession().getAttribute("empId") == null) {
            // ログイペレイト
            response.sendRedirect("LoginServlet");
            return;
        }

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/A100/welcome.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int emprole = Integer.parseInt(request.getParameter("emprole"));
        if (emprole == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/A100/reception.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/A100/physician.jsp");
            dispatcher.forward(request, response);
        }
    }
}