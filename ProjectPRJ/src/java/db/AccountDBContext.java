/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Object.Account;
import Object.Feature;
import Object.Role;
import Object.Student;
import Object.Teacher;
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
public class AccountDBContext extends DBContext<Account> {

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Account getByID(String id, String Password, boolean status) {
        try {
            String sql = "SELECT Account,Password,Status FROM Account\n"
                    + "WHERE Account = ? AND [password] = ? AND Status = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, Password);
            stm.setBoolean(3, status);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setAccount(rs.getString("Account"));
                account.setPassword(rs.getString("Password"));
                account.setStatus(rs.getBoolean("Status"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Student getAcReturnStu(String id, String Password) {
        try {
            String sql = "SELECT S.StudentID, S.StudentName FROM Account A, Student S\n"
                    + "WHERE A.Account = ? AND A.[password] = ? AND A.Account=S.Account";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, Password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student stu = new Student();
                stu.setStudentid(rs.getInt("StudentID"));
                stu.setStudentname(rs.getString("StudentName"));
                return stu;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Teacher getAcReturnTea(String id, String Password) {
        try {
            String sql = "select TeacherID, TeacherName from Teacher t , Account a\n"
                    + "where t.Account = a.Account and a.Account = ? and a.Password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, Password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Teacher stu = new Teacher();
                stu.setTeacherID(rs.getInt("TeacherID"));
                stu.setTeacherName(rs.getString("TeacherName"));
                return stu;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Role getRole(int id) {
        Role role = new Role();
        try {
            String sql = "select r.name, f.url from [Role Feature] rf, [Roles] r, Feature f\n"
                    + "where rf.rid=r.id and f.fid=rf.fid and r.id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            ArrayList ar = new ArrayList<Feature>();
            while (rs.next()) {
                role.setName(rs.getString("name"));
                ar.add(new Feature(rs.getString("url")));
            }
            role.setFeatures(ar);
            return role;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
