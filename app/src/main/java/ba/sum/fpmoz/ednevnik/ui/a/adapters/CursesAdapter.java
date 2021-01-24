package ba.sum.fpmoz.ednevnik.ui.a.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import ba.sum.fpmoz.ednevnik.R;
import ba.sum.fpmoz.ednevnik.model.Classes;
import ba.sum.fpmoz.ednevnik.model.Curses;

public class CursesAdapter extends FirebaseRecyclerAdapter<Curses,CursesAdapter.cursesHolder> {

    public CursesAdapter(@NonNull FirebaseRecyclerOptions<Curses> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull cursesHolder holder, int position, @NonNull Curses model) {
        holder.curseNameTxt.setText(model.getName());
    }

    @NonNull
    @Override
    public cursesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_curses_list_item,parent,false);
        return new CursesAdapter.cursesHolder(itemView);
    }

    public class cursesHolder extends RecyclerView.ViewHolder{
        TextView curseNameTxt;
        Button curseEditBtn;
        Button curseDeleteBtn;

        public cursesHolder(@NonNull View itemView) {
            super(itemView);
            curseNameTxt = itemView.findViewById(R.id.curseNameTxt);
            curseEditBtn = itemView.findViewById(R.id.curseEditBtn);
            curseDeleteBtn = itemView.findViewById(R.id.curseDeleteBtn);

            curseDeleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getRef(getAdapterPosition()).removeValue();
                }
            });

             /* curseEditBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = getRef(getAdapterPosition()).getKey();
                    Intent i = new Intent(itemView.getContext(), CurseEditAdminActivity.class);
                    i.putExtra("USER_ID", key);
                    itemView.getContext().startActivity(i);
                }
            });
            */
        }
    }
}
