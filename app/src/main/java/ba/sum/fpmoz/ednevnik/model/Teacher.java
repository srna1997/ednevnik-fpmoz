package ba.sum.fpmoz.ednevnik.model;

public class Teacher {
    public String uId;
    public String displayName;
    public String email;
    public String role;

    public Teacher() {
    }

    public Teacher(String uId, String displayName, String email, String role) {
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
