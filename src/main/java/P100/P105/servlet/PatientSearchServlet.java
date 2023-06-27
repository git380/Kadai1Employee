package P100.P105.servlet;

import P100.P105.model.PatientSearch;
import P100.P105.model.PatientSearchLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/PatientSearchServlet")
public class PatientSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションスコープからロールを取得
        if (request.getSession().getAttribute("emprole") == null) {
            // ログイペレイト
            response.sendRedirect("LoginServlet");
            return;
        } else if ((int) request.getSession().getAttribute("emprole") == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/A100/reception.jsp");
            dispatcher.forward(request, response);
        }

        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");

        // 患者の検索
        PatientSearchLogic searchLogic = new PatientSearchLogic();
        ArrayList<PatientSearch> patients = searchLogic.searchPatient();

        // 検索結果をリクエスト属性に設定
        request.setAttribute("patients", patients);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P105/patientSearchResult.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Kadai1Employee/WelcomeServlet");
        dispatcher.forward(request, response);
    }
}