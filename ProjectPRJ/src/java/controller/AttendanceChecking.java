/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Object.Group;
import Object.StudentInGroup;
import db.GroupDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
@WebServlet(name = "AttendanceChecking", urlPatterns = {"/AttendanceChecking"})
public class AttendanceChecking extends BaseRequiredAuthenticationController {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AttendanceChecking</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceChecking at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        GroupDBContext gdb = new GroupDBContext();
        Group gr = gdb.get(Integer.parseInt(request.getSession().getAttribute("groupID").toString()), Date.valueOf(request.getSession().getAttribute("Date").toString()));
        request.setAttribute("groupar", gr.getStudentar());
        HttpSession session = request.getSession();
        session.setAttribute("gr", gr);
        request.getRequestDispatcher("view/AttendanceChecking.jsp").forward(request, response);
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AttendanceChecking</title>");
//            out.println("</head>");
//            out.println("<body>");
//            //----------------------------------------------------
//            out.println("<table style=\"width:100%\">");
//            out.println("<form><tr>\n"
//                    + "    <th>StudentID</th>\n"
//                    + "    <th>Student Name</th>\n"
//                    + "    <th style=\"text-align:center\">Attendance Status</th>\n"
//                    + "  </tr>");
//            for (StudentInGroup sig : (ArrayList<StudentInGroup>) gr.getStudentAr()) {
//                out.println("<tr>");
//                out.println("<td style=\"text-align:center\">" + sig.getStudent().getStudentID()
//                        + "<td style=\"text-align:center\">" + sig.getStudent().getStudentName()+"</td>");
//                out.println("<td style=\"text-align:center\"><form action=\"abc\" method=POST><input type=\"radio\" checked=\"Checked\" value=\""+sig.getStudentinclassid()+"Attend"+"\">" + "Attend"
//                        + "<input type=\"radio\" value=\""+sig.getStudentinclassid()+"Absent"+"\">" + "Absent "
//                        + "<input type=\"text\" name=\""+sig.getStudentinclassid()+" Note"+"\">"+ " Note "
//                        + "<button type=submit>submit"
//                        + "</form>");
//                out.println("</tr>");
//            }
//            out.println("</form>");
//            out.println("</table>");
//            //----------------------------------------------------
//            out.println("</body>");
//            out.println("</html>");
//        }
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
