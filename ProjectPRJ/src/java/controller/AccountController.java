/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Object.Account;
import Object.Group;
import Object.StudentInGroup;
import Object.Slot;
import Object.Student;
import db.AccountDBContext;
import db.GroupDBContext;
import db.StudentInGroupDBContext;
import db.SlotDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Dell
 */
public class AccountController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        AccountDBContext dbc = new AccountDBContext();
        String logger = request.getParameter("logger");
        String uname = request.getParameter("uname");
        String password = request.getParameter("psw");
        boolean log = !logger.equals("teacher");
        Student stu = dbc.getAcReturnStu(uname, password, log);
        Account ac = dbc.getByID(uname, password, log);
        HttpSession session = request.getSession();
        if (stu != null) {
            session.setAttribute("stuname", stu.getStudentName());
            session.setAttribute("stuid", stu.getStudentID());
            StudentInGroupDBContext grd = new StudentInGroupDBContext();
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = Date.valueOf(formatter.format(calendar.getTime()));
            ArrayList<StudentInGroup> grdArray = grd.list(stu.getStudentID(), date);
            Calendar cal1 = Calendar.getInstance();
            Date date1 = Date.valueOf(formatter.format(cal1.getTime()));
            request.setAttribute("date", date1);
            session.setAttribute("grd", grdArray);
            session.setAttribute("ac", ac);
            SlotDBContext g = new SlotDBContext();
            ArrayList<Slot> ar = g.list();
            session.setAttribute("slt", ar);
        }
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
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
