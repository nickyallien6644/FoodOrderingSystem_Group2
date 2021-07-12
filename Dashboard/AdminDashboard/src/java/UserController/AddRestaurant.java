/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import Models.DAO.AccountDAO;
import Models.DAO.RestaurantDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phuct
 */
public class AddRestaurant extends HttpServlet {

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
        try {
            PrintWriter out = response.getWriter();
            
            //Format date
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            String timeOp = request.getParameter("timeOpen").toString()+":00";
            String timeCl = request.getParameter("timeClose").toString()+":00";
            Date dateClose = dateFormat.parse(timeCl);
            Date dateOpen = dateFormat.parse(timeOp);

            String name = request.getParameter("name").toString();
            Time timeOpen = new Time(dateOpen.getHours(), dateOpen.getMinutes(), dateOpen.getSeconds());
            Time timeClose = new Time(dateClose.getHours(), dateClose.getMinutes(), dateOpen.getSeconds());
            String address = request.getParameter("address").toString();
            String phone = request.getParameter("phone").toString();
            String image = request.getParameter("file").toString();

            RestaurantDAO restaurantDAO = new RestaurantDAO();

            boolean checkUpdate = false;
            
            checkUpdate = restaurantDAO.insertRestaurant(name, timeOpen, timeClose, address, phone, image);

            if (checkUpdate == true) {
                out.println("<script type=\"text/javascript\">");
                out.println("location='./Admin/indexRestaurant.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("location='./Admin/AddRestaurant.jsp';");
                out.println("</script>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(AddRestaurant.class.getName()).log(Level.SEVERE, null, ex);
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
