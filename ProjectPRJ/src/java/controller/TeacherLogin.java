/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import Object.Account;
import Object.Slot;
import Object.StudentInGroup;
import Object.Teacher;
import db.AccountDBContext;
import db.SlotDBContext;
import db.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Dell
 */
@WebServlet(name="TeacherLogin", urlPatterns={"/TeacherLogin"})
public class TeacherLogin extends BaseRequiredAuthenticationController {
   
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
            out.println("<title>Servlet TeacherLogin</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherLogin at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AccountDBContext dbc = new AccountDBContext();
        Account ac = (Account)request.getSession().getAttribute("ac");
        Teacher tea = dbc.getAcReturnTea(ac.getAccount(), ac.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute("teaname", tea.getTeacherName());
        session.setAttribute("teaid", tea.getTeacherID());
        TeacherDBContext tdb = new TeacherDBContext();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.valueOf(formatter.format(calendar.getTime()));
        ArrayList<StudentInGroup> grdArray = tdb.list(tea.getTeacherID(), date);
        Calendar cal1 = Calendar.getInstance();
        Date date1 = Date.valueOf(formatter.format(cal1.getTime()));
        request.setAttribute("date", date1);
        session.setAttribute("grd", grdArray);
        SlotDBContext g = new SlotDBContext();
        ArrayList<Slot> ar = g.list();
        session.setAttribute("slt", ar);
        request.getRequestDispatcher("view/teacherLogin.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
