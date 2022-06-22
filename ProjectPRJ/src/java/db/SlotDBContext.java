/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Object.Slot;
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
public class SlotDBContext extends DBContext<Slot>{

    @Override
    public ArrayList<Slot> list() {
        ArrayList ar = new ArrayList<Slot>();
        try {
            String sql = "select SlotID, StartTime, EndTime from Slot";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot room = new Slot();
                room.setSlotid(rs.getInt("SlotID"));
                room.setStarttime(rs.getTime("StartTime"));
                room.setEndtime(rs.getTime("EndTime"));
                ar.add(room);
            }
            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Slot get(int id) {
        try {
            String sql = "select SlotID, StartTime, EndTime from Slot\n"
                    + "where SlotID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Slot room = new Slot();
                room.setSlotid(rs.getInt("SlotID"));
                room.setStarttime(new SlotDBContext().get(rs.getInt("SlotID")).getStarttime());
                room.setEndtime(new SlotDBContext().get(rs.getInt("SlotID")).getStarttime());
                return room;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//public static void main(String[] args) {
//        SlotDBContext g = new SlotDBContext();
//        ArrayList<Slot> ar = g.list();
//        for (Slot e : ar) {
//            System.out.println(e);
//        }
//    }
    @Override
    public void insert(Slot model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Slot model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Slot model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
