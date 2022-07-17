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
    private Course course;
    private Teacher teacher;
    private Room room;
    private Slot slot;
    private ArrayList<StudentInGroup> studentar;

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ArrayList<StudentInGroup> getStudentar() {
        return studentar;
    }

    public void setStudentar(ArrayList<StudentInGroup> studentar) {
        this.studentar = studentar;
    }
    
}
