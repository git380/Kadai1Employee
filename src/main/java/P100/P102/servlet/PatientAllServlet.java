package P100.P102.servlet;

import P100.P102.model.PatientUpdateLogic;
import P100.P105.model.PatientSearch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/PatientAllServlet")
public class PatientAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションスコープからユーザーIDを取得
        if (request.getSession().getAttribute("empId") == null) {
            // ログイペレイト
            response.sendRedirect("LoginServlet");
            return;
        }
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");

        // 患者の検索
        PatientUpdateLogic searchLogic = new PatientUpdateLogic();
        ArrayList<PatientSearch> patients = searchLogic.allPatient();

        // 検索結果をリクエスト属性に設定
        request.setAttribute("patients", patients);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P102/patientAll.jsp");
        dispatcher.forward(request, response);
    }
}