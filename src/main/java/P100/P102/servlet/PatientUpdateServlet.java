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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/PatientUpdateServlet")
public class PatientUpdateServlet extends HttpServlet {
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

        // 変更する患者を取得
        String patId = request.getParameter("patId");
        String patFname = request.getParameter("patFname");
        String patLname = request.getParameter("patLname");
        String hokenmei = request.getParameter("hokenmei");
        String hokenexp = request.getParameter("hokenexp");

        request.setAttribute("patId", patId);
        request.setAttribute("patFname", patFname);
        request.setAttribute("patLname", patLname);
        request.setAttribute("hokenmei", hokenmei);
        request.setAttribute("hokenexp", hokenexp);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P102/patientUpdate.jsp");
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
        String oldhokenexp = request.getParameter("oldhokenexp");

        request.setAttribute("patId", patId);
        request.setAttribute("patFname", patFname);
        request.setAttribute("patLname", patLname);
        request.setAttribute("hokenmei", hokenmei);
        request.setAttribute("hokenexp", hokenexp);

        System.out.println(patId + " " + hokenmei + " " + hokenexp);

        if (hokenexp == null || hokenexp.equals("")) {
            request.setAttribute("hokenexp", oldhokenexp);
            request.setAttribute("error", 0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P102/changeError.jsp");
            dispatcher.forward(request, response);
        } else {
            // hokenexp の日付を LocalDate に変換
            LocalDate expirationDate = LocalDate.parse(hokenexp, formatter);
            LocalDate oldExpirationDate = LocalDate.parse(oldhokenexp, formatter);
            if (expirationDate.isAfter(oldExpirationDate)) {
                // 登録処理の実行
                PatientUpdate patient = new PatientUpdate(patId, hokenmei, hokenexp);
                PatientUpdateLogic bo = new PatientUpdateLogic();
                bo.updatePatient(patient);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P102/changeOK.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error", 1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P102/changeError.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}