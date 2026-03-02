package ca.uottawa.csi3540.lab4.servlet;

import ca.uottawa.csi3540.lab4.util.AppConstants;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("usernamePrefill", getSavedUsernameFromCookie(request));
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String usernameInput = request.getParameter("username");
        String username = usernameInput == null ? "" : usernameInput.trim();

        if (username.isEmpty()) {
            request.setAttribute("error", "Le username est obligatoire.");
            request.setAttribute("usernamePrefill", usernameInput == null ? "" : usernameInput);
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
            return;
        }

        HttpSession previousSession = request.getSession(false);
        if (previousSession != null) {
            previousSession.invalidate();
        }

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(600);
        session.setAttribute(AppConstants.SESSION_USERNAME, username);

        Cookie cookie = new Cookie(
                AppConstants.COOKIE_USERNAME,
                URLEncoder.encode(username, StandardCharsets.UTF_8)
        );
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/exam1");
    }

    private String getSavedUsernameFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "";
        }

        for (Cookie cookie : cookies) {
            if (AppConstants.COOKIE_USERNAME.equals(cookie.getName())) {
                return URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
            }
        }
        return "";
    }
}
