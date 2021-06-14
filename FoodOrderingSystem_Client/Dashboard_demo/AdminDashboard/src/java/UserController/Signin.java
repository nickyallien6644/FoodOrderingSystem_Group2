/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import Models.DAO.UserDAO;
import Models.Entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Signin", urlPatterns = {"/Signin"})
public class Signin extends HttpServlet {

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
         
        //get User Name and password when Customer inptut
        String username = request.getParameter("SigninName");
        String password = request.getParameter("SigninPassword");
        UserDAO us = new UserDAO(); // constructor User
        User user = new User();
        user = us.signIn(username, password); // call funtion to sinup
            // if null it mean user not have exist and sendirect failed.jsp
           if(user == null ){
               //TODO : MAKE forget password
               request.setAttribute("message", "Cant't Login <br/> Wrong username or password .. ");
               getServletContext().getRequestDispatcher("/Failed.jsp").forward(request, response);
           } else {
            
            //set session for login user
            HttpSession session = request.getSession(true);
            session.setAttribute("LoginUser", user);
            session.setMaxInactiveInterval(60*15);
            
               if(user.getRoleID() ==  2 || user.getRoleID() == 3 || user.getRoleID()== 4){
                   System.out.println("ADMIN");
                   response.sendRedirect("index.jsp");
               }
               else {
                   System.out.println("NOT");
                   response.sendRedirect("login.jsp");
               }                  //user
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
