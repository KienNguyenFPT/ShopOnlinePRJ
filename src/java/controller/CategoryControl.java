package controller;

import dao.DAO;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author Trung Kien
 */
@WebServlet(name = "CategoryControl", urlPatterns = {"/category"})
public class CategoryControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String category_id = request.getParameter("cid");
        String index = request.getParameter("index");
        if(index == null) index = "1";
        int indexPage = Integer.parseInt(index);
        
        
        DAO dao = new DAO();
        List<Product> list = dao.getProductByCateID(category_id);
        List<Category> listC = dao.getAllCategory();
        List<Product> listPagingByCateID = dao.getPagingByCateID(category_id, indexPage);
        
        int cnt = dao.getTotalByCateID(category_id);
        int numPage = cnt / 6;
        if(cnt%6 !=0) numPage++;
        
        request.setAttribute("context", "category");
        request.setAttribute("tag", indexPage);
        //request.setAttribute("indexPage", indexPage);
        request.setAttribute("endPage", numPage);
        request.setAttribute("listP", listPagingByCateID);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
