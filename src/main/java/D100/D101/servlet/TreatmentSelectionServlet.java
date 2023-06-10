package D100.D101.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/TreatmentSelectionServlet")
public class TreatmentSelectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patId = request.getParameter("patId");
        HttpSession session = request.getSession();
        session.setAttribute("patId", patId);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/D100/D101/treatmentSelection.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータから処理情報を取得
        String patId = request.getParameter("patId");
        String medicineId = request.getParameter("medicineId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String impDate = request.getParameter("impDate");

        // リクエストスコープに処理情報を保存
        request.setAttribute("patId", patId);
        request.setAttribute("medicineId", medicineId);
        request.setAttribute("quantity", quantity);
        request.setAttribute("impDate", impDate);

        // JSPにフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/D100/D101/treatmentSelectionResult.jsp").forward(request, response);
    }
}