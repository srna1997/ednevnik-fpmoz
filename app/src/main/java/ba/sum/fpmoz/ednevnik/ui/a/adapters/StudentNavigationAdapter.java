package ba.sum.fpmoz.ednevnik.ui.a.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import ba.sum.fpmoz.ednevnik.R;
import ba.sum.fpmoz.ednevnik.model.Curses;
import ba.sum.fpmoz.ednevnik.model.Student;

public class StudentNavigationAdapter extends FirebaseRecyclerAdapter<Curses,StudentNavigationAdapter.studentNavigationHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public StudentNavigationAdapter(@NonNull FirebaseRecyclerOptions<Curses> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull studentNavigationHolder holder, int position, @NonNull Curses model) {
            holder.curseNameTxt.setText(model.getName());
    }

    @NonNull
    @Override
    public studentNavigationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_student_curses_list_item,parent,false);
        return new StudentNavigationAdapter.studentNavigationHolder(itemView);
    }

    public class studentNavigationHolder extends RecyclerView.ViewHolder {
        TextView curseNameTxt;

        public studentNavigationHolder(@NonNull View itemView) {
            super(itemView);
            curseNameTxt = itemView.findViewById(R.id.studentCurseNameTxt);
        }
    }
}
