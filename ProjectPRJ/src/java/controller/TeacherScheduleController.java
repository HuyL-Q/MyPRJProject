/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import Object.StudentInGroup;
import db.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
@WebServlet(name="TeacherScheduleController", urlPatterns={"/TeacherScheduleController"})
public class TeacherScheduleController extends BaseRequiredAuthenticationController {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TeacherScheduleController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherScheduleController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acID = request.getParameter("accountID");
        Date date = Date.valueOf(request.getParameter("date"));
        TeacherDBContext tdb = new TeacherDBContext();
        ArrayList<StudentInGroup> grdArray = tdb.list(Integer.parseInt(acID), date);
        request.setAttribute("grd", grdArray);
        request.setAttribute("date", date);
        request.getRequestDispatcher("view/teacherLogin.jsp").forward(request, response);
    }

}
