package br.edu.unidavi.cleber.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirCookie", urlPatterns = {"/ExcluirCookie"})
public class ExcluirCookie extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            
            Cookie cookie = new Cookie(request.getParameter("nome"), request.getParameter("valor"));
            cookie.setMaxAge(0); //1 hour
            response.addCookie(cookie);
            response.sendRedirect("GravarCookie");
        }
    }

}
