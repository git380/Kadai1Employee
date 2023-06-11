package P100.P104.servlet;

import P100.P104.model.PatientExpiration;
import P100.P104.model.PatientExpirationLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PatientExpirationServlet")
public class PatientExpirationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PatientExpirationLogic expirationLogic = new PatientExpirationLogic();
        List<PatientExpiration> expiredPatients = expirationLogic.searchExpired();

        request.setAttribute("expiredPatients", expiredPatients);
        request.setAttribute("date", new java.sql.Date(new java.util.Date().getTime()));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/P100/P104/patientSearch.jsp");
        dispatcher.forward(request, response);
    }
}
