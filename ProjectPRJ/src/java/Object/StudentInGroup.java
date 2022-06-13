/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class StudentInGroup {
    private int StudentID;
    private int ClassID;
    private Date Date;
    private int StudentInClassID;

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getStudentInClassID() {
        return StudentInClassID;
    }

    public void setStudentInClassID(int StudentInClassID) {
        this.StudentInClassID = StudentInClassID;
    }
    
}
