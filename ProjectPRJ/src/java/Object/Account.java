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
public class Account {
    private String account;
    private String password;
    private boolean status;
    private ArrayList<Role> roles = new ArrayList<>();

    public String getAccount() {
        return account;
    }

    public void setAccount(String Account) {
        this.account = Account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean Status) {
        this.status = Status;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    
}
