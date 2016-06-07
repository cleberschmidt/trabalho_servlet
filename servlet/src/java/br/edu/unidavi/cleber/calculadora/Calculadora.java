package br.edu.unidavi.cleber.calculadora;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet(name = "Session", urlPatterns = {"/Session"})
public class Calculadora extends HttpServlet {

    public String buscarSinal(String sinal){
        switch (sinal){
            case "adicao":
                sinal = "+";
                break;
            case "subtracao":
                sinal = "-";
                break;
            case "multiplicacao":
                sinal = "*";
                break;
            case "divisao":
                sinal = "/";
                break;
        }
        return sinal;
    }
    
    public String realizarCalculo(String num01, String num02, String sinal){
        float num01f = Float.parseFloat(num01); 
        float num02f = Float.parseFloat(num02);
        float resultado = 0;
        switch (sinal){
            case "adicao":
                resultado = num01f + num02f;
                break;
            case "subtracao":
                resultado = num01f - num02f;
                break;
            case "multiplicacao":
                resultado = num01f * num02f;
                break;
            case "divisao":
                resultado = num01f / num02f;
                break;
        }
        String retorno = String.valueOf(resultado);
        return retorno;
    }
    
    // Se houver somente zeros depois da vírgula o número é formatado para não mostrar o(s) zero(s)
    public String verificaZeroDepoisVirgula(String resultado){
    //16 numeros total
        int cont = 0;
        String[] res;
        for(int i=0;i< resultado.length();i++){
            String caracter = String.valueOf(resultado.charAt(i));
            if(caracter.equals(",")){
                for(int s=(i+1);s< resultado.length();s++){
                    String caracterDepoisVirgula = String.valueOf(resultado.charAt(s));
                    if(caracterDepoisVirgula.equals("0")){
                        cont++;
                    }
                }

            if(resultado.length()-(i+1) == cont){
                res = resultado.split(",");
                resultado = res[0];
            }
            break;    
            }
        }   
        return resultado;
    }
    
    public String verificaSeTemSomenteUmZeroDepoisDoSinal(String resultado){
    //16 numeros total
        int cont = 0;
        String[] res;
        for(int i=0;i< resultado.length();i++){
            String caracter = String.valueOf(resultado.charAt(i));
            if(caracter.equals(",")){
                for(int s=(i+1);s< resultado.length();s++){
                    String caracterDepoisVirgula = String.valueOf(resultado.charAt(s));
                    if(caracterDepoisVirgula.equals("0")){
                        cont++;
                        if(cont == 2){
                            
                        }
                    }
                }

            if(resultado.length()-(i+1) == cont){
                res = resultado.split(",");
                resultado = res[0];
            }
            break;    
            }
        }   
        return resultado;
    }
    
    public String verificaPrimeiroZero(String resultado){
        if(resultado.length() == 1 && resultado.equals("0")){
            resultado = "";
        }
        return resultado;
    }
    
    private String isSomenteSinal(String resultado){        
        if(resultado.equals("+") || resultado.equals("/") || resultado.equals("*") || resultado.equals("-")){
            resultado = "";
        }
        return resultado;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //  retirar segundo zero
        
        HttpSession session = request.getSession();
        
        String resultado;
        if (session.getAttribute("resultadoFinal") != null) {
            resultado = (String) session.getAttribute("resultadoFinal");
            
            
            
            
            if(request.getParameter("igual") != null && session.getAttribute("sinal") != null && session.getAttribute("num02") != null){
                String sinal = (String) session.getAttribute("sinal");
                //String resultadoQuebrado = resultado.replace(buscarSinal(sinal), ",");
                //String[] conta = resultadoQuebrado.split(",");
                
                String num01 = (String) session.getAttribute("num01");
                String num02 = (String) session.getAttribute("num02");
                
                resultado = realizarCalculo(num01, num02, sinal);
                
                session.setAttribute("num01", resultado);
                session.setAttribute("num02", null);
                session.setAttribute("resultadoFinal", null);
                session.setAttribute("sinal", null);
            }
            
            if(session.getAttribute("sinal") == null && !resultado.equals("0")){
                if(request.getParameter("adicao") != null){ 
                    resultado = request.getParameter("adicao");
                    session.setAttribute("sinal", "adicao");
                }else if(request.getParameter("subtracao") != null){ 
                    resultado = request.getParameter("subtracao");
                    session.setAttribute("sinal", "subtracao");
                }else if(request.getParameter("multiplicacao") != null){ 
                    resultado = request.getParameter("multiplicacao");
                    session.setAttribute("sinal", "multiplicacao");
                }else if(request.getParameter("divisao") != null){ 
                    resultado = request.getParameter("divisao");
                    session.setAttribute("sinal", "divisao");
                }
            }
            
            
            
            
            if(request.getParameter("c") != null){
                resultado = "0";   
                session.setAttribute("num01", null);
                session.setAttribute("num02", null);
                session.setAttribute("resultadoFinal", null);
                session.setAttribute("sinal", null);
            }else if(request.getParameter("num1") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num1");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num2") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num2");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num3") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num3");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num4") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num4");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num5") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num5");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num6") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num6");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num7") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num7");

                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }  
            }else if(request.getParameter("num8") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num8");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num9") != null){
                resultado = isSomenteSinal(resultado);
                
                resultado = verificaPrimeiroZero(resultado);
                resultado = resultado + request.getParameter("num9");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
            }else if(request.getParameter("num0") != null){
                resultado = isSomenteSinal(resultado);
                if(resultado.equals("0")){
                    resultado = resultado.replaceFirst("0", "");
                }
               
                resultado = resultado + request.getParameter("num0");
                
                if(session.getAttribute("sinal") == null){
                    session.setAttribute("num01", resultado);
                }else{
                    session.setAttribute("num02", resultado);
                }
                 
            }
            
            String num01 = (String) session.getAttribute("num01");
            String num02 = (String) session.getAttribute("num02");
            System.out.println("num01 "+num01);
            System.out.println("num02 "+num02);
            System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
            
            resultado = resultado.replace(".", ",");
            
            resultado = verificaZeroDepoisVirgula(resultado);
            
            
            
            session.setAttribute("resultadoFinal", resultado);
        }else{
            session.setAttribute("resultadoFinal", "0");
        }
    
             
            //configurando para a sessão expirar em 30 minutos
            session.setMaxInactiveInterval(30 * 60);
                
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Calculadora Session</title>");
                out.println("<style>");
                out.println(".inputNum1{"
                          + "height: 41px;"
                          + "width: 41px;"
                          + "margin-left: -3px;"
                          + "}"
                );
                out.println(".inputNum2{"
                          + "height: 41px;"
                          + "width: 41px;"
                          + "}"
                );
                out.println(".botoes{"
                          + "margin-left: 3px;"
                          + "margin-bottom: 2px;"
                          + "}"
                );
                out.println("</style>");
                
                
                out.println("</head>");
                out.println("<body>");
                out.println("<div style=\"border:1px solid #ccc; width:174px; background: #607d8b;\">");
                
                out.println("<form>");
                out.println("<input type=\"text\" value=\""+session.getAttribute("resultadoFinal")+"\" style=\"text-align:right; padding:8px; width:149px; margin: 2px 2px 2px 2px\" disabled />");
                out.println("<div class=\"botoes\" >");
                out.println("<input type=\"submit\" name=\"num7\" value=\"7\" class=\"inputNum2\">");
                out.println("<input type=\"submit\" name=\"num8\" value=\"8\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"num9\" value=\"9\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"divisao\" value=\"/\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"num4\" value=\"4\" class=\"inputNum2\">");
                out.println("<input type=\"submit\" name=\"num5\" value=\"5\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"num6\" value=\"6\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"multiplicacao\" value=\"*\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"num1\" value=\"1\" class=\"inputNum2\">");
                out.println("<input type=\"submit\" name=\"num2\" value=\"2\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"num3\" value=\"3\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"subtracao\" value=\"-\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"num0\" value=\"0\" class=\"inputNum2\">");
                out.println("<input type=\"submit\" name=\"igual\" value=\"=\" class=\"inputNum1\">");
                out.println("<input type=\"submit\" name=\"c\" value=\"C\" class=\"inputNum1\">"); 
                out.println("<input type=\"submit\" name=\"adicao\" value=\"+\"  class=\"inputNum1\">");
                out.println("</div>");
                out.println("</form>");
                out.println("</div>");
                
                
                out.println("</body>");
                out.println("</html>");
            
        }
    }
}
