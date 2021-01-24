package ba.sum.fpmoz.ednevnik.ui.a.fragments.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.ednevnik.R;
import ba.sum.fpmoz.ednevnik.model.Student;
import ba.sum.fpmoz.ednevnik.model.Teacher;
import ba.sum.fpmoz.ednevnik.ui.a.adapters.StudentAdapter;
import ba.sum.fpmoz.ednevnik.ui.a.adapters.TeacherAdapter;

public class ListTeacherFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference ref;
    TeacherAdapter adapter;
    RecyclerView teacherRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View teacherListAdminView = inflater.inflate(R.layout.activity_teacher_list,container,false);

        this.teacherRecyclerView = teacherListAdminView.findViewById(R.id.teacherRecyclerView);
        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/nastavnici");
        this.teacherRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Teacher> options = new FirebaseRecyclerOptions
                .Builder<Teacher>()
                .setQuery(this.ref, Teacher.class).build();
        this.adapter = new TeacherAdapter(options);
        this.teacherRecyclerView.setAdapter(this.adapter);

        return teacherListAdminView;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
