package D100.D102.servlet;

import D100.D102.model.MedicineDeletionLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MedicineDeletionServlet")
public class MedicineDeletionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String medicineId = request.getParameter("medicineId");

        MedicineDeletionLogic logic = new MedicineDeletionLogic();
        logic.deleteMedicine(medicineId);

        response.sendRedirect("/WEB-INF/jsp/D100/D101/medicineConfirmation.jsp");
    }
}
