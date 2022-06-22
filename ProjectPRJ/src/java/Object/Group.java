/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Group {
    private int groupid;
    private String courseid;
    private int teacher;
    private int room;
    private int slot;
    private ArrayList StudentAr;

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String Courseid) {
        this.courseid = Courseid;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public ArrayList getStudentAr() {
        return StudentAr;
    }

    public void setStudentAr(ArrayList StudentAr) {
        this.StudentAr = StudentAr;
    }

   
    
}
