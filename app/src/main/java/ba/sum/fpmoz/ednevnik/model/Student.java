package ba.sum.fpmoz.ednevnik.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student {
    public String uId;
    public String displayName;
    public String email;
    public String role;

    public Student() {
    }

    public Student(String uId,String displayName, String email,String role) {
        this.uId = uId;
        this.displayName = displayName;
        this.email = email;
        this.role = role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
