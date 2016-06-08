/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.cleber.formulario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovoTeste", urlPatterns = "/teste2")
public class Formulario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        montaForm(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
               //String teste =  req.getParameter("sexo");
               //req.setAttribute("teste", teste);
        
       
       
        
/*
        System.out.println("ERRRO: " + erro);

        if (erro == null) {
            req.setAttribute("msg", "OK, gravado.");
        } else {
            req.setAttribute("msg", erro);
        }
        System.out.println("LOG: " + req.getParameter("nome"));*/
        

        montaForm(req, resp);
    }

    protected void montaForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String nome         = "";
            String email        = "";
            String sexo         = "";
            String comentario   = "";
            
           
            
            
            if (req.getParameter("nome") != null) {
                nome = req.getParameter("nome");
            }
            if(req.getParameter("email") != null){
                email = req.getParameter("email");
            }
            if(req.getParameter("comentario") != null){
                comentario = req.getParameter("comentario");
            }

             
        
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet teste</title>");
            out.println("<style>");
            out.println(".box{"   
                          + "width: 480px;"
                          + "padding: 15px;"
                          + "border: 1px solid #ccc;"
                          + "}"
            );
            out.println("label{"   
                          + ""
                          + "}"
            );
            out.println(".inputCima{"   
                          + "width:250px;"
                          
                          + "}"
            );
            out.println("input[type=\"text\"]{"   
                          + "margin-left:4px;"
                          + "margin-bottom: 10px;"
                          + "}"
            );
            
                out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"box\">");
            out.println("<form method=\"post\">");
            
            out.println("<label>Nome:</label>");
            out.println("<input type=\"text\" name=\"nome\" value=\""+nome+"\" class=\"inputCima\"/>"); 
            
            out.println("<label>Sexo: </label>");            
            if(req.getParameter("sexo") != null){
                sexo = req.getParameter("sexo");
                if(sexo.equals("m")){
                    out.println("<input type=\"radio\" name=\"sexo\" value=\"m\" checked/>");
                    out.println("<label>M</label>");
                    out.println("<input type=\"radio\" name=\"sexo\" value=\"f\" />");
                    out.println("<label>F</label>");
                    out.println("<br>");
                }else if(sexo.equals("f")){
                    out.println("<input type=\"radio\" name=\"sexo\" value=\"m\"/>");
                    out.println("<label>M</label>");
                    out.println("<input type=\"radio\" name=\"sexo\" value=\"f\" checked/>");
                    out.println("<label>F</label>");
                    out.println("<br>");
                }
            }else{
                out.println("<input type=\"radio\" name=\"sexo\" value=\"m\"   />");
                out.println("<label>M</label>");
                out.println("<input type=\"radio\" name=\"sexo\" value=\"f\" />");
                out.println("<label>F</label>");
                out.println("<br>");
            }
        
            out.println("<label>E-mail:</label>");
            out.println("<input type=\"email\" name=\"email\" value=\""+email+"\" class=\"inputCima\" />");
            out.println("<br>");
            out.println("<br>");
  
            out.println("<label>Navegador preferido:</label>"); 
            if(req.getParameter("navegadorPreferido") != null){
                if(req.getParameter("navegadorPreferido").equals("1")){
                    out.println("<select name=\"navegadorPreferido\">"
                    + "<option value=\"0\" disabled selected>Escolha uma Opção</option>"
                    + "<option value=\"1\" selected>Opera  </option>"
                    + "<option value=\"2\">Chrome </option>"
                    + "<option value=\"3\">Mozilla</option>"
                    + "</select>");
                }else if(req.getParameter("navegadorPreferido").equals("2")){
                    out.println("<select name=\"navegadorPreferido\">"
                    + "<option value=\"0\" disabled selected>Escolha uma Opção</option>"
                    + "<option value=\"1\">Opera  </option>"
                    + "<option value=\"2\" selected>Chrome </option>"
                    + "<option value=\"3\">Mozilla</option>"
                    + "</select>");
                }else if(req.getParameter("navegadorPreferido").equals("3")){
                    out.println("<select name=\"navegadorPreferido\">"
                    + "<option value=\"0\" disabled selected>Escolha uma Opção</option>"
                    + "<option value=\"1\">Opera  </option>"
                    + "<option value=\"2\">Chrome </option>"
                    + "<option value=\"3\" selected>Mozilla</option>"
                    + "</select>");
                }
            }else{
                out.println("<select name=\"navegadorPreferido\">"
                + "<option value=\"0\" disabled selected>Escolha uma Opção</option>"
                + "<option value=\"1\">Opera  </option>"
                + "<option value=\"2\">Chrome </option>"
                + "<option value=\"3\">Mozilla</option>"
                + "</select>");
            }
            out.println("<br>");
            out.println("<br>");
            
            out.println("<label>Esportes que aprecia: </label>");
            out.println("<br>");
            if(req.getParameter("futebol") != null){
                out.println("<input type=\"checkbox\" name=\"futebol\" checked>");
            }else{
                out.println("<input type=\"checkbox\" name=\"futebol\">");
            }
            out.println("<label>futebol</label>");
            
            if(req.getParameter("baskete") != null){
                out.println("<input type=\"checkbox\" name=\"baskete\" checked>");
            }else{
                out.println("<input type=\"checkbox\" name=\"baskete\">");
            }
            out.println("<label>baskete</label>");
            
            if(req.getParameter("tenis") != null){
                out.println("<input type=\"checkbox\" name=\"tenis\" checked>");
            }else{
                out.println("<input type=\"checkbox\" name=\"tenis\">");
            }
            out.println("<label>tênis</label>");
            
            if(req.getParameter("volei") != null){
                out.println("<input type=\"checkbox\" name=\"volei\" checked>");
            }else{
                out.println("<input type=\"checkbox\" name=\"volei\">");
            }
            out.println("<label>volei</label>");
            
            if(req.getParameter("handebol") != null){
                out.println("<input type=\"checkbox\" name=\"handebol\" checked>");
            }else{
                out.println("<input type=\"checkbox\" name=\"handebol\">");
            }
            out.println("<label>handebol</label>");
            
            if(req.getParameter("nenhum") != null){
                out.println("<input type=\"checkbox\" name=\"nenhum\" checked>");
            }else{
                out.println("<input type=\"checkbox\" name=\"nenhum\">");
            }
            out.println("<label>nenhum deles</label>");
            out.println("<br>");
            out.println("<br>");
            
            out.println("<label>Comentário sobre o esporte preferido</label>");
            out.println("<br>");
            out.println("<textarea name=\"comentario\" cols=\"60\" rows=\"4\" >"+comentario+"</textarea>");
            out.println("<br>");
            out.println("<input type=\"submit\" value=\"Enviar\"/>");
            out.println("<input type=\"reset\" name=\"limpar\" value=\"Limpar\"/>");
            out.println("</form>");
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
