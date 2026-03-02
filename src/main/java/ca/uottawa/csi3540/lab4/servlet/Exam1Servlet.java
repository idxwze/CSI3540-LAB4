package ca.uottawa.csi3540.lab4.servlet;

import ca.uottawa.csi3540.lab4.util.AppConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Exam1Servlet extends BaseProtectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = requireAuthenticatedSession(request, response);
        if (session == null) {
            return;
        }

        request.setAttribute("currentAnswer", session.getAttribute(AppConstants.SESSION_EXAM1_ANSWER));
        request.getRequestDispatcher("/WEB-INF/jsp/exam1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = requireAuthenticatedSession(request, response);
        if (session == null) {
            return;
        }

        Integer answer = parseInteger(request.getParameter("answer"));
        if (answer == null) {
            request.setAttribute("error", "Veuillez entrer une valeur numérique.");
            request.setAttribute("currentAnswer", request.getParameter("answer"));
            request.getRequestDispatcher("/WEB-INF/jsp/exam1.jsp").forward(request, response);
            return;
        }

        session.setAttribute(AppConstants.SESSION_EXAM1_ANSWER, answer);
        response.sendRedirect(request.getContextPath() + "/exam2");
    }

    private Integer parseInteger(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
