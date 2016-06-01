package br.edu.unidavi.cleber.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarCookie", urlPatterns = {"/AlterarCookie"})
public class AlterarCookie extends HttpServlet {

    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
         
        try (PrintWriter out = response.getWriter()) {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Cookie</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<form method=\"post\">");
            out.println("<input type=\"text\" name=\"nomeAlterar\"  value=\""+request.getParameter("nome")+"\" style=\"background:#e0e0e0;border:1px solid #ccc; padding: 2px\" readonly/>");
            out.println("<input type=\"text\" name=\"valorAlterar\" value=\""+request.getParameter("valor")+"\"/>");
            out.println("<input type=\"submit\" name=\"alterar\" value=\"Alterar\"/>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
            
            if(request.getParameter("valorAlterar") != null){
                Cookie cookie = new Cookie(request.getParameter("nomeAlterar"), request.getParameter("valorAlterar"));
                cookie.setMaxAge(60 * 60); 
                response.addCookie(cookie);
                
                
                
                response.sendRedirect("GravarCookie");
            }
        }
        
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        //response.sendRedirect("GravarCookie");
    }


}
