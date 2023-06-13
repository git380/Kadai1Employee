package D100.D101.servlet;

import D100.D101.model.Medicine;
import D100.D101.model.MedicineLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TreatmentSelectionServlet")
public class TreatmentSelectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");

        // 全件検索で処置ボタンが押されたpatidを取得
        String patId = request.getParameter("patId");

        // 患者の検索
        MedicineLogic medicineLogic = new MedicineLogic();
        List<Medicine> medicines = medicineLogic.getMedicines();

        /*// デバッグ用に中身を出力
        for (Medicine medicine : medicines) {
            System.out.println("Medicine ID: " + medicine.getMedicineId());
            System.out.println("Medicine Name: " + medicine.getMedicineName());
            System.out.println("Unit: " + medicine.getUnit());
        }*/

        // 検索結果をリクエスト属性に設定
        request.setAttribute("patId", patId);
        request.setAttribute("medicines", medicines);

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