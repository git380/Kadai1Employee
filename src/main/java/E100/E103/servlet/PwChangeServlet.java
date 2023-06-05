package E100.E103.servlet;

import E100.E103.model.PwChangeLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PwChangeServlet")
public class PwChangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/E100/E103/pwChange.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // IDを取得
        //Account account = new Account();
        String empId = request.getParameter("empId");

        // 変更するパスワードを取得
        String empPasswd = request.getParameter("empPasswd");

        // 変更処理の実行
        PwChangeLogic bo = new PwChangeLogic();
        bo.empPasswd(empId, empPasswd);

        /*// 変更処理の結果に応じてメッセージを設定
        if (result) {
            request.setAttribute("message", "PWの変更が完了しました");
        } else {
            request.setAttribute("message", "PWの変更に失敗しました");
        }*/

        response.sendRedirect("/Kadai1Employee/");
    }
}