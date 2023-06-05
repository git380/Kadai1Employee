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

@WebServlet("/MedicineSelectionServlet")
public class MedicineSelectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MedicineLogic logic = new MedicineLogic();
        List<Medicine> medicines = logic.getAllMedicines();

        request.setAttribute("medicines", medicines);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/D101/medicineSelection.jsp");
        dispatcher.forward(request, response);
    }
}