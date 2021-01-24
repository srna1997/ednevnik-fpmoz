package ba.sum.fpmoz.ednevnik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ba.sum.fpmoz.ednevnik.model.Student;

public class UserEditAdminActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;

    EditText studentDisplayNameEdt;
    EditText studentEmailEdt;

    Button studentEditBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_admin);

        this.studentDisplayNameEdt = findViewById(R.id.teacherDisplayNameEdt);
        this.studentEmailEdt = findViewById(R.id.teacherEmailEdt);
        this.studentEditBtn = findViewById(R.id.classEditBtn);

        final String key = getIntent().getStringExtra("USER_ID");

        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/ucenici/").child(key);

        this.studentEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student s = new Student();
                s.displayName = studentDisplayNameEdt.getText().toString();
                s.email = studentEmailEdt.getText().toString();

                ref.setValue(s);



            }
        });

        this.ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Student student = snapshot.getValue(Student.class);
                studentDisplayNameEdt.setText(student.displayName);
                studentEmailEdt.setText(student.email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}