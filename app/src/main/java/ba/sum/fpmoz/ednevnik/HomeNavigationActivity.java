package ba.sum.fpmoz.ednevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.ednevnik.model.User;

public class HomeNavigationActivity extends AppCompatActivity {

    private ImageButton usersBtn;
    private ImageButton classesBtn;
    private ImageButton cursesBtn;

    private User loggedUser;
    FirebaseUser user;
    FirebaseDatabase db;
    DatabaseReference Adminref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        setTitle("Dobrodošli u administraciju");

        this.usersBtn = findViewById(R.id.usersBtn);
        this.classesBtn = findViewById(R.id.classesBtn);
        this.cursesBtn = findViewById(R.id.coursesBtn);

        this.usersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TabbedUserAdminActivity.class);
                startActivity(i);
            }
        });

        this.classesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TabbedClassAdminActivity.class);
                startActivity(i);
            }
        });

        this.cursesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TabbedCurseAdminActivity.class);
                startActivity(i);
            }
        });


    }



}
