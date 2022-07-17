/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Object.Course;
import Object.DateConverter;
import Object.Group;
import Object.Slot;
import Object.StudentInGroup;
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
public class TeacherDBContext extends DBContext {

    public ArrayList<StudentInGroup> list(int id, Date date) {
        ArrayList ar = new ArrayList<StudentInGroup>();
        try {
            String sql = "select SIC.StudenInClassID,c.ClassID , t.TeacherID, t.TeacherName, c.CourseID, s.SlotID, SIC.[Date] from Teacher t, Class c, Slot s, StudentInClass SIC\n"
                    + "where t.TeacherID=c.TeacherID and t.TeacherID = ? and s.SlotID=c.SlotID and SIC.ClassID = c.ClassID and SIC.Date between ? and ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            DateConverter dc = new DateConverter();
            Date date2 = dc.sunToCurrentDate(date);
            Date date1 = dc.currentDateToSat(date);
            stm.setDate(2, date2);
            stm.setDate(3, date1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Teacher te = new Teacher();
                te.setTeacherID(rs.getInt("TeacherID"));
                te.setTeacherName(rs.getString("TeacherName"));
                Group gr = new Group();
                Course co = new Course();
                co.setCourseid(rs.getString("CourseID"));
                gr.setGroupid(rs.getInt("ClassID"));
                gr.setCourse(co);
                Slot sl = new Slot();
                sl.setSlotid(rs.getInt("SlotID"));
                gr.setSlot(sl);
                gr.setTeacher(te);
                StudentInGroup Sig = new StudentInGroup();
                Sig.setDate(rs.getDate("Date"));
                Sig.setStudentinclassid(rs.getInt("StudenInClassID"));
                Sig.setGroup(gr);
                Sig.converter();
                ar.add(Sig);
            }
            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
