package ba.sum.fpmoz.ednevnik.model;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

public class User {
    String uid;
    String displayName;
    String email;
    public String role;

    public User(Task<GetTokenResult> idToken, String displayName, String email, String role) {
    }

    public User(String displayName, String email, String role) {
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

}
