/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Dell
 */
public class StudentInGroup {
    private Student student;
    private Group group;
    private Date date;
    private int studentinclassid;
    private Attendance attendance;
    private int dayinweek;

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
    
    public void converter(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        this.setDayinweek(dayOfWeek);
    }

    public int getDayinweek() {
        return dayinweek;
    }

    public void setDayinweek(int dayinweek) {
        this.dayinweek = dayinweek;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStudentinclassid() {
        return studentinclassid;
    }

    public void setStudentinclassid(int studentinclassid) {
        this.studentinclassid = studentinclassid;
    }

}
