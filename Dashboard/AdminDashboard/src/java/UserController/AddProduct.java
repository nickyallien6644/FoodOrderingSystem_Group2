/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import Models.DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phuct
 */
public class AddProduct extends HttpServlet {

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
        //ADD product
        PrintWriter out = response.getWriter();
        //Inclue rId, pName, pPrice, description, image, category
        int rId = Integer.parseInt(request.getParameter("id").toString());
        String pName = request.getParameter("name").toString();
        int pPrice = Integer.parseInt(request.getParameter("price").toString());
        String description = request.getParameter("description").toString();
        String image = request.getParameter("file").toString();
        int category = Integer.parseInt(request.getParameter("category").toString());
        //init ProductDAO
        ProductDAO productDAO = new ProductDAO();
        //if insert product success will return Max(pId)
        int checkInsert = 0;
        boolean check = false;

        checkInsert = productDAO.insertProduct(pName, pPrice, description, category, rId);
        if (checkInsert != 0) {
            //If check insert !=0, will continue insert image
            check = productDAO.insertImage(checkInsert, image);
            if (check == true) {
                out.println("<script type=\"text/javascript\">");
                out.println("location='./Employee/productManagement.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("location='./Employee/AddProduct.jsp';");
                out.println("</script>");
            }
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("location='./Employee/AddProduct.jsp';");
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
