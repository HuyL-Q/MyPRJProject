/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Dell
 */
public class Student {
    private int studentid;
    private String studentname;
    private boolean Gender;
    private Account Account;
    private int AttendaceCount;

    public int getStudentID() {
        return studentid;
    }

    public void setStudentID(int StudentID) {
        this.studentid = StudentID;
    }

    public String getStudentName() {
        return studentname;
    }

    public void setStudentName(String StudentName) {
        this.studentname = StudentName;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public Account getAccount() {
        return Account;
    }

    public void setAccount(Account Account) {
        this.Account = Account;
    }

    public int getAttendaceCount() {
        return AttendaceCount;
    }

    public void setAttendaceCount(int AttendaceCount) {
        this.AttendaceCount = AttendaceCount;
    }
    
    
}
