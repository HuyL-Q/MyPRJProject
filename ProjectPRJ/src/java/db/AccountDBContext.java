/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Object.Account;
import Object.Student;
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

    public Student getAcReturnStu(String id, String Password, boolean status) {
        try {
            String sql = "SELECT S.StudentID, S.StudentName FROM Account A, Student S\n"
                    + "WHERE A.Account = ? AND A.[password] = ? AND A.Status = ? AND A.Account=S.Account";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, Password);
            stm.setBoolean(3, status);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student stu = new Student();
                stu.setStudentID(rs.getInt("StudentID"));
                stu.setStudentName(rs.getString("StudentName"));
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

}
