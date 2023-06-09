package D100.D103.servlet;

import D100.D103.model.TreatmentConfirmation;
import D100.D103.model.TreatmentConfirmationLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TreatmentConfirmationServlet")
public class TreatmentConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータから処理情報を取得
        String patId = request.getParameter("patId");
        String medicineId = request.getParameter("medicineId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String impDate = request.getParameter("impDate");

        // D101で入力した情報を画面に表示するためにリクエストスコープに保存
        request.setAttribute("patId", patId);
        request.setAttribute("medicineId", medicineId);
        request.setAttribute("quantity", quantity);
        request.setAttribute("impDate", impDate);

        TreatmentConfirmation treatment = new TreatmentConfirmation(patId, medicineId, quantity, impDate);

        // 処置確定処理の実行
        TreatmentConfirmationLogic bo = new TreatmentConfirmationLogic();
        bo.newTreatment(treatment);

        // 処置確定画面にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/D100/D103/treatmentConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}
