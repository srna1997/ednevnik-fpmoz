package ba.sum.fpmoz.ednevnik.ui.a.fragments.curses;

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
import ba.sum.fpmoz.ednevnik.model.Curses;
import ba.sum.fpmoz.ednevnik.ui.a.adapters.ClassesAdapter;
import ba.sum.fpmoz.ednevnik.ui.a.adapters.CursesAdapter;

public class ListCursesFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference ref;
    CursesAdapter adapter;
    RecyclerView cursesRecyclerView;

     @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View curseListAdminView = inflater.inflate(R.layout.activity_curses_list, container, false);

        this.cursesRecyclerView = curseListAdminView.findViewById(R.id.cursesRecyclerView);
        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/predmeti");
        this.cursesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Curses> options = new FirebaseRecyclerOptions
                .Builder<Curses>()
                .setQuery(this.ref, Curses.class).build();
        this.adapter = new CursesAdapter(options);
        this.cursesRecyclerView.setAdapter(this.adapter);

        return curseListAdminView;
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
