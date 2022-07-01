/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Object.DateConverter;
import Object.Group;
import Object.StudentInGroup;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class StudentInGroupDBContext extends DBContext<StudentInGroup> {

//    public static void main(String[] args) {
//        StudentInGroupDBContext st = new StudentInGroupDBContext();
//        ArrayList<StudentInGroup> ar = st.list(2);
//        for (StudentInGroup obj : ar) {
//            System.out.println(obj);
//        }
//    }
    @Override
    public ArrayList<StudentInGroup> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<StudentInGroup> list(int id, Date date) {
        ArrayList ar = new ArrayList<StudentInGroup>();
        try {
            String sql = "SELECT C.ClassID, SIC.Date, C.CourseID, C.RoomID, C.SlotID FROM [Class] C, Student S, StudentInClass SIC\n"
                    + "where S.StudentID = SIC.StudentID AND SIC.ClassID = C.ClassID AND S.StudentID= ? and\n"
                    + "SIC.[Date] between ? and ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            DateConverter dc = new DateConverter();
            Date date2= dc.sunToCurrentDate(date);
            Date date1= dc.currentDateToSat(date);
            stm.setDate(2, date2);
            stm.setDate(3, date1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group Gr = new Group();
                Gr.setRoom(rs.getInt("RoomID"));
                Gr.setGroupid(rs.getInt("ClassID"));
                Gr.setCourseid(rs.getString("CourseID"));
                Gr.setSlot(rs.getInt("SlotID"));
                StudentInGroup sic = new StudentInGroup();
                sic.setGroup(Gr);
                sic.setDate(rs.getDate("Date"));
                sic.converter();
                ar.add(sic);
            }
            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StudentInGroup get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(StudentInGroup model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(StudentInGroup model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(StudentInGroup model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
