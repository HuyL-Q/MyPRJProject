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
import Object.Attendance;
import Object.Student;
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
                Room ro = new Room();
                ro.setRoomID(rs.getInt("RoomID"));
                Gr.setRoom(ro);
                Gr.setGroupid(rs.getInt("ClassID"));
                Course co = new Course();
                co.setCourseid(rs.getString("CourseID"));
                Gr.setCourse(co);
                Slot sl = new Slot();
                sl.setSlotid(rs.getInt("SlotID"));
                Gr.setSlot(sl);
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
                Room ro = new Room();
                ro.setRoomID(rs.getInt("RoomID"));
                Gr.setRoom(ro);
                Gr.setGroupid(rs.getInt("ClassID"));
                Course co = new Course();
                co.setCourseid(rs.getString("CourseID"));
                Gr.setCourse(co);
                Slot sl = new Slot();
                sl.setSlotid(rs.getInt("SlotID"));
                Gr.setSlot(sl);
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
    
    public Group get(int GroupID, Date date) {//return student that learn in groupid at date
        Group gr = new Group();
        ArrayList<StudentInGroup> ar = new ArrayList();
        try {
            String sql = "select s.StudentID, c.ClassID, c.CourseID, sic.StudenInClassID, s.StudentName, sic.Date, a.Status from StudentInClass sic, Attendance a, Class c, Student s\n"
                    + "where a.StudentInClassID = sic.StudenInClassID and c.ClassID=sic.ClassID and c.ClassID = ? and s.StudentID=sic.StudentID and sic.Date= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, GroupID);
            stm.setDate(2, date);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                Attendance a = new Attendance();
                StudentInGroup sig = new StudentInGroup();
                stu.setStudentid(rs.getInt("StudentID"));
                sig.setDate(rs.getDate("Date"));
                stu.setStudentname(rs.getString("StudentName"));
                sig.setStudentinclassid(rs.getInt("StudenInClassID"));
                a.setStatus(rs.getBoolean("Status"));
                Course co = new Course();
                co.setCourseid(rs.getString("CourseID"));
                gr.setCourse(co);
                sig.setStudent(stu);
                gr.setGroupid(rs.getInt("ClassID"));
                sig.setAttendance(a);
                ar.add(sig);
            }
            gr.setStudentar(ar);
            return gr;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
