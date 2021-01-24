package ba.sum.fpmoz.ednevnik.ui.a.fragments.curses;

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
import ba.sum.fpmoz.ednevnik.model.Curses;

public class AddCursesFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference ref;

    EditText curseName;
    Button addCurseBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View curseAdminView = inflater.inflate(R.layout.activity_add_curses, container, false);

        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/predmeti");

        this.curseName = curseAdminView.findViewById(R.id.curseNameInp);
        this.addCurseBtn = curseAdminView.findViewById(R.id.addCurseBtn);

        this.addCurseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return curseAdminView;
    }
}
