/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Object.Room;
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
public class RoomDBContext extends DBContext<Room>{

    @Override
    public ArrayList<Room> list() {
        ArrayList ar = new ArrayList<Room>();
        try {
            String sql = "select RoomID, RoomName from Room";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("RoomID"));
                room.setRoomName("RoomName");
                ar.add(room);
            }
            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Room get(int id) {
        try {
            String sql = "select RoomID, RoomName from Room where RoomID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("RoomID"));
                room.setRoomName("RoomName");
            return room;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Room model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Room model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Room model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
