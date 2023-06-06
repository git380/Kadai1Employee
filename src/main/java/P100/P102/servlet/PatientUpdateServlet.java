package P100.P102.servlet;

import P100.P102.model.PatientUpdate;
import P100.P102.model.PatientUpdateLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PatientUpdateServlet")
public class PatientUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P102/patientUpdate.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String patId = request.getParameter("patId");
        String hokenmei = request.getParameter("hokenmei");
        String hokenexp = request.getParameter("hokenexp");

        // 登録処理の実行
        PatientUpdate patient = new PatientUpdate(patId, hokenmei, hokenexp);
        PatientUpdateLogic bo = new PatientUpdateLogic();
        bo.updatePatient(patient);

        System.out.println(patId + hokenmei + hokenexp);

        response.sendRedirect("/Kadai1Employee/WelcomeServlet");
    }
}