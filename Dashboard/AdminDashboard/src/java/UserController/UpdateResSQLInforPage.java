/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import Models.DAO.RestaurantDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phuct
 */
public class UpdateResSQLInforPage extends HttpServlet {

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
        //Format date
        String timeOp = request.getParameter("timeOpen").toString();
        String timeCl = request.getParameter("timeClose").toString();
        String name = request.getParameter("name").toString();
        String address = request.getParameter("address").toString();
        String phone = request.getParameter("phone").toString();
        String image = request.getParameter("file").toString();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        boolean checkUpdate = false;
        if (image != "") {
            checkUpdate = restaurantDAO.updateRestaurant(id, name, timeOp, timeCl, address, phone, image);
        } else {
            checkUpdate = restaurantDAO.updateRestaurantNoImage(id, name, timeOp, timeCl, address, phone);
        }
        if (checkUpdate == true) {
            out.println("<script type=\"text/javascript\">");
            out.println("location='./Staff/RestaurantInformation.jsp?id=" + id + "';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("location='./Staff/RestaurantInformation.jsp?id=" + id + "';");
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
