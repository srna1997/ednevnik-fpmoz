package ba.sum.fpmoz.ednevnik.ui.a.fragments.users;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.ednevnik.MainActivity;
import ba.sum.fpmoz.ednevnik.R;
import ba.sum.fpmoz.ednevnik.model.Student;
import ba.sum.fpmoz.ednevnik.model.Teacher;
import ba.sum.fpmoz.ednevnik.model.User;
import ba.sum.fpmoz.ednevnik.ui.a.adapters.TabbedAdapter;

public class AddUsersFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference refAdmin;
    DatabaseReference refTeacher;
    DatabaseReference refStudent;
    TextView message;
    EditText displayNameInp;
    EditText emailInp;
    EditText passwordInp;
    EditText passwordCnfInp;
    Button registerBtn;
    Spinner spinner;

    public AddUsersFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View userAdminView = inflater.inflate(R.layout.activity_register,container,false);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        this.refAdmin = this.db.getReference("ednevnik/admini");
        this.refTeacher = this.db.getReference("ednevnik/nastavnici");
        this.refStudent = this.db.getReference("ednevnik/ucenici");

        this.message = userAdminView.findViewById(R.id.registerMsg);
        this.displayNameInp = userAdminView.findViewById(R.id.displayNameInp);
        this.emailInp = userAdminView.findViewById(R.id.emailInp1);
        this.passwordInp = userAdminView.findViewById(R.id.passwordInp1);
        this.passwordCnfInp = userAdminView.findViewById(R.id.passwordCnfInp);
        this.registerBtn = userAdminView.findViewById(R.id.registerBtn1);
        this.spinner = userAdminView.findViewById(R.id.roleSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(userAdminView.getContext(),R.array.roles,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        this.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayName = displayNameInp.getText().toString();
                String email = emailInp.getText().toString();
                String password = passwordInp.getText().toString();
                String passwordCnf = passwordCnfInp.getText().toString();
                String role = spinner.getSelectedItem().toString();

                if(!password.equals(passwordCnf)){
                    message.setText("Lozinke se ne podudaraju,ponovno unesite točnu lozinku");
                }
                else {
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                UserProfileChangeRequest changeRequest = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(displayName).build();

                                user.updateProfile(changeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            if(role.equals("Admin")){
                                                refAdmin.push().setValue(
                                                        new User(user.getIdToken(true),displayName,email,role));
                                            } else if(role.equals("Nastavnik"))
                                            {
                                                refTeacher.push().setValue(
                                                        new Teacher(displayName,email,role));
                                            }else
                                            {
                                                refStudent.push().setValue(
                                                        new Student(displayName,email,role));

                                            }

                                            emailInp.setText("");
                                            passwordInp.setText("");
                                            passwordCnfInp.setText("");
                                            displayNameInp.setText("");
                                            message.setText("Novi korisnik je ažuriran");
                                            Log.d("Poruka","Profil je ažuriran");
                                        }
                                        else{
                                            Toast.makeText(
                                                    userAdminView.getContext(),
                                                    "Uspješno ste dodali učenika.", Toast.LENGTH_LONG).show();
                                        };
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });

        return userAdminView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String itemValue = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),itemValue,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
