package P100.P103.servlet;

import P100.P103.model.PatientSearchLogic;
import P100.P103.model.PatientSearchResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PatientSearchServlet")
public class PatientSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P103/pSearch.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String patfname = request.getParameter("patfname");
        String patlname = request.getParameter("patlname");

        // 患者の検索
        PatientSearchLogic searchLogic = new PatientSearchLogic();
        List<PatientSearchResult> patients = searchLogic.searchPatient(patfname, patlname);

        // 検索結果をリクエスト属性に設定
        request.setAttribute("patients", patients);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P103/pSearchResult.jsp");
        dispatcher.forward(request, response);
    }
}