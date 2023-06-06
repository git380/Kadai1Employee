package D100.D103.servlet;

import D100.D103.model.TreatmentConfirmationLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TreatmentConfirmationServlet")
public class TreatmentConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TreatmentConfirmationLogic logic = new TreatmentConfirmationLogic();
        logic.confirmTreatment();

        response.sendRedirect("/WEB-INF/jsp/D100/D101/treatmentConfirmation.jsp");
    }
}
