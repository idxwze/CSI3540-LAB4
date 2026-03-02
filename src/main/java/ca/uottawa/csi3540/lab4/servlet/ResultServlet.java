package ca.uottawa.csi3540.lab4.servlet;

import ca.uottawa.csi3540.lab4.util.AppConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ResultServlet extends BaseProtectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = requireAuthenticatedSession(request, response);
        if (session == null) {
            return;
        }

        Integer exam1Answer = getInteger(session.getAttribute(AppConstants.SESSION_EXAM1_ANSWER));
        Integer exam2Answer = getInteger(session.getAttribute(AppConstants.SESSION_EXAM2_ANSWER));

        if (exam1Answer == null) {
            response.sendRedirect(request.getContextPath() + "/exam1");
            return;
        }
        if (exam2Answer == null) {
            response.sendRedirect(request.getContextPath() + "/exam2");
            return;
        }

        int score = 0;
        if (exam1Answer == AppConstants.EXAM1_CORRECT_ANSWER) {
            score++;
        }
        if (exam2Answer == AppConstants.EXAM2_CORRECT_ANSWER) {
            score++;
        }

        session.setAttribute(AppConstants.SESSION_SCORE, score);

        request.setAttribute("username", session.getAttribute(AppConstants.SESSION_USERNAME));
        request.setAttribute("score", score);
        request.setAttribute("total", AppConstants.EXAM_TOTAL_QUESTIONS);
        request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
    }

    private Integer getInteger(Object value) {
        return value instanceof Integer ? (Integer) value : null;
    }
}
