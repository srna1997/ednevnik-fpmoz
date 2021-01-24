package ba.sum.fpmoz.ednevnik.ui.a.fragments.classes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.ednevnik.R;
import ba.sum.fpmoz.ednevnik.model.Classes;

public class AddClassFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference ref;

    EditText classesName;
    EditText classesUid;
    Button addClassesBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View userAdminView = inflater.inflate(R.layout.activity_add_class, container, false);

        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/razredi");

        this.classesName = userAdminView.findViewById(R.id.classesNameAddTxt);
        this.classesUid = userAdminView.findViewById(R.id.classesUidAddTxt);

        this.addClassesBtn = userAdminView.findViewById(R.id.addClassesBtn);
        this.addClassesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return userAdminView;
    }
}
