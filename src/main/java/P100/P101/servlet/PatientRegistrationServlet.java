package P100.P101.servlet;

import P100.P101.model.PatientRegistration;
import P100.P101.model.PatientRegistrationLogic;
import P100.P102.model.PatientUpdate;
import P100.P102.model.PatientUpdateLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/PatientRegistrationServlet")
public class PatientRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションスコープからロールを取得
        if (request.getSession().getAttribute("emprole") == null) {
            // ログイペレイト
            response.sendRedirect("LoginServlet");
            return;
        } else if ((int) request.getSession().getAttribute("emprole") == 2) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/A100/physician.jsp");
            dispatcher.forward(request, response);
        }

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P101/patientRegistration.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 日付のフォーマットを定義
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String patId = request.getParameter("patId");
        String patFname = request.getParameter("patFname");
        String patLname = request.getParameter("patLname");
        String hokenmei = request.getParameter("hokenmei");
        String hokenexp = request.getParameter("hokenexp");

        PatientRegistrationLogic bo = new PatientRegistrationLogic();

        if (bo.nullPatient(patId)) {//IDかぶりなし
            // hokenexp の日付を LocalDate に変換
            LocalDate expirationDate = LocalDate.parse(hokenexp, formatter);
            LocalDate currentDate = LocalDate.now();
            if (expirationDate.isAfter(currentDate)) {
                // 登録処理の実行
                PatientRegistration patient = new PatientRegistration(patId, patFname, patLname, hokenmei, hokenexp);
                bo.newPatient(patient);

                System.out.println(patId + patFname + patLname + hokenmei + hokenexp);
                // フォワード
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P101/registrationOK.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error", 1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P101/registrationError.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // フォワード
            request.setAttribute("error", 0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P101/registrationError.jsp");
            dispatcher.forward(request, response);
        }
    }
}