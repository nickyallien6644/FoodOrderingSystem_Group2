/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import Models.DAO.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phuct
 */
@WebServlet(name = "AddAccount", urlPatterns = {"/AddAccount"})
public class AddAccount extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String first_name = request.getParameter("first_name").toString();
        String last_name = request.getParameter("last_name").toString();
        String phone = request.getParameter("phone").toString();
        String address = request.getParameter("address").toString();
        String email = request.getParameter("email").toString();
        String password = request.getParameter("password").toString();
        int role = Integer.parseInt(request.getParameter("selectStatus").toString());
        AccountDAO accountDAO = new AccountDAO();
        
        boolean checkUpdate = false;

        checkUpdate = accountDAO.insertAccount(first_name, last_name, phone, email, address, role, password);

        if (checkUpdate == true) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Update account success');");
            out.println("location='./Admin/index.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Update account fail');");
            out.println("location='./Admin/AddAccount.jsp';");
            out.println("</script>");
        }

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
