package P100.P101.servlet;

import P100.P101.model.PatientRegistration;
import P100.P101.model.PatientRegistrationLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PatientRegistrationServlet")
public class PatientRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P101/pRegistration.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String patId = request.getParameter("patId");
        String patFname = request.getParameter("patFname");
        String patLname = request.getParameter("patLname");
        String hokenmei = request.getParameter("hokenmei");
        String hokenexp = request.getParameter("hokenexp");

        // 登録処理の実行
        PatientRegistration patient = new PatientRegistration(patId, patFname, patLname, hokenmei, hokenexp);
        PatientRegistrationLogic bo = new PatientRegistrationLogic();
        bo.newPatient(patient);

        System.out.println(patId + patFname + patLname + hokenmei + hokenexp);

        response.sendRedirect("/Kadai1Employee/LoginServlet");
    }
}