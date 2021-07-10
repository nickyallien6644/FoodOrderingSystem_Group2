/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import Models.DAO.AccountDAO;
import Models.Entity.Account;
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
@WebServlet(name = "UpdateAccount", urlPatterns = {"/UpdateAccount"})
public class UpdateAccount extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        String first_name = request.getParameter("firstName").toString();
        String last_name = request.getParameter("lastName").toString();
        String phone = request.getParameter("phone").toString();
        String address = request.getParameter("address").toString();
        String email = request.getParameter("email").toString();
        String status = request.getParameter("selectStatus").toString();
        int selectStatus = -1;
        if (status.equalsIgnoreCase("Active") || status.equalsIgnoreCase("1")) {
            selectStatus = 1;
        } else if (status.equalsIgnoreCase("Inactive") || status.equalsIgnoreCase("0")) {
            selectStatus = 0;
        }

        AccountDAO accountDAO = new AccountDAO();
        boolean checkUpdate = false;
        if (selectStatus != -1) {
            checkUpdate = accountDAO.updateAccount(id, first_name, last_name, phone, email, address, selectStatus);
        }
        if (checkUpdate == true) {
            out.println("<script type=\"text/javascript\">");
            out.println("location='./Admin/UpdateProfile.jsp?id="+id+"';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("location='./Admin/UpdateProfile.jsp?id="+id+"';");
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
