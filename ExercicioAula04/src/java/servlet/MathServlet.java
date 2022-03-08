/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hihugo1
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/mathservlet"})
public class MathServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
        double n1 = 1;
        double n2 = 1;
        double result;
        String op = null;
        String error = null;
        try{
            String p1 = request.getParameter("n1");
            String p2 = request.getParameter("n2");
            op = request.getParameter("op");
            n1 = Double.parseDouble(p1);
            n2 = Double.parseDouble(p2);

            
        }catch(Exception ex){
            error = ex.getMessage();
        }
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Escolha um tipo de operação</h2>");
            out.println("<form>");
            out.println("<input type='number' name='n1' value='1'/>");
            out.println("<select name='op'>");
            out.println("<option>+</option>");
            out.println("<option>-</option>");
            out.println("<option>*</option>");
            out.println("<option>/</option>");
            out.println("</select>");
            out.println("<input type='number' name='n2' value='1'/>");
            out.println("<input type='submit' value='='/>");
            out.println("</form>");
            out.println("<hr>");
            if(error!=null){
                out.println("<div style='color:red'>Erro na tentativa de leitura dos parâmetros: "+error+"</div>");
            }else{
                out.println("<div>");
                switch(op){
                    case "+": 
                        result = n1+n2;
                        out.println(n1+" + "+n2+" = "+result);
                        break;
                    case "-":
                        result = n1-n2;
                        out.println(n1+" - "+n2+" = "+result);
                        break;
                    case "*":
                        result = n1 * n2;
                        out.println(n1+" * "+n2+" = "+result);
                        break;
                    case "/": 
                        result = n1 / n2;
                        out.println(n1+" / "+n2+" = "+result);
                        break;
                    default:
                        out.println("Invalido");
                }
                out.println("</div>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
