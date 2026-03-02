package ca.uottawa.csi3540.lab4.servlet;

import ca.uottawa.csi3540.lab4.util.AppConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public abstract class BaseProtectedServlet extends HttpServlet {
    protected HttpSession requireAuthenticatedSession(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(AppConstants.SESSION_USERNAME) == null) {
            response.sendRedirect(request.getContextPath() + "/register");
            return null;
        }
        return session;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp);
    }
}
