/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Object.Course;
import Object.DateConverter;
import Object.Group;
import Object.Room;
import Object.Slot;
import Object.Teacher;
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
public class GroupDBContext extends DBContext<Group> {

    @Override
    public ArrayList<Group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Group> listByName(int id) {//return student group list
        ArrayList ar = new ArrayList<Group>();
        try {
            String sql = "SELECT C.ClassID, SIC.Date, C.CourseID, C.RoomID, C.SlotID FROM [Class] C, Student S, StudentInClass SIC\n"
                    + "where S.StudentID = SIC.StudentID AND SIC.ClassID = C.ClassID AND S.StudentID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group Gr = new Group();
                Gr.setRoom(rs.getInt("RoomID"));
                Gr.setGroupid(rs.getInt("ClassID"));
                Gr.setCourseid(rs.getString("CourseID"));
                Gr.setSlot(rs.getInt("SlotID"));
                ar.add(Gr);
            }
            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Group> listByDate(int id, Date date) {
        ArrayList ar = new ArrayList<Group>();
        try {
            String sql = "SELECT C.ClassID, SIC.Date, C.CourseID, C.RoomID, C.SlotID FROM [Class] C, Student S, StudentInClass SIC\n"
                    + "where S.StudentID = SIC.StudentID AND SIC.ClassID = C.ClassID AND S.StudentID= 2 and\n"
                    + "SIC.[Date]<? and SIC.[Date]>?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            DateConverter dc = new DateConverter();
            stm.setDate(2, dc.currentDateToSat(date));
            stm.setDate(3, dc.sunToCurrentDate(date));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group Gr = new Group();
                Gr.setRoom(rs.getInt("RoomID"));
                Gr.setGroupid(rs.getInt("ClassID"));
                Gr.setCourseid(rs.getString("CourseID"));
                Gr.setSlot(rs.getInt("SlotID"));
                ar.add(Gr);
            }
            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Group get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
