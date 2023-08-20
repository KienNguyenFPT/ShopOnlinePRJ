package controller;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 *
 * @author Trung Kien
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("name");
        String pass = request.getParameter("password");
        String gmail = request.getParameter("email");
        String repass = request.getParameter("re_password");
        
        DAO dao = new DAO();
        if(!repass.equals(pass)) {
            request.setAttribute("message", "Password was not match!");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
        else {
            //Account a;
            if(dao.checkExistGmail(gmail) != null) {
                request.setAttribute("message", "This gmail was register! Try again!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            else if(dao.checkExistUser(user) != null) {
                request.setAttribute("message", "This username was register! Try again!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }           
            else {
                dao.signup(user, pass, gmail);
                dao.sendEmail(gmail, user);
                request.setAttribute("message", "Register SUCCESSFULLY!");
                
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }             
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
// trung username -> Login, show message
// repass != pass -> Login, show message
// trung gmail -> Login
