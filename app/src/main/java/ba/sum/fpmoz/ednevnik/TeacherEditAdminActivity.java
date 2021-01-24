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

import ba.sum.fpmoz.ednevnik.model.Teacher;

public class TeacherEditAdminActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;

    EditText teacherDisplayNameEdt;
    EditText teacherEmailEdt;
    Button teacherEditBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_edit_admin);

        this.teacherDisplayNameEdt = findViewById(R.id.teacherDisplayNameEdt);
        this.teacherEmailEdt = findViewById(R.id.teacherEmailEdt);
        this.teacherEditBtn = findViewById(R.id.classEditBtn);

        final String key = getIntent().getStringExtra("USER_ID");

        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/nastavnici/").child(key);

        this.teacherEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Teacher t = new Teacher();
                t.displayName = teacherDisplayNameEdt.getText().toString();
                t.email = teacherEmailEdt.getText().toString();

                ref.setValue(t);
            }
        });

        this.ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Teacher teacher = snapshot.getValue(Teacher.class);
                teacherDisplayNameEdt.setText(teacher.displayName);
                teacherEmailEdt.setText(teacher.email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}