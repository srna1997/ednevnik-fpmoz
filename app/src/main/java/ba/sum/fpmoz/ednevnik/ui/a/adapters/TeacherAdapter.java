package ba.sum.fpmoz.ednevnik.ui.a.adapters;

import android.content.Intent;
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
import ba.sum.fpmoz.ednevnik.TeacherEditAdminActivity;
import ba.sum.fpmoz.ednevnik.model.Teacher;

public class TeacherAdapter extends FirebaseRecyclerAdapter<Teacher,TeacherAdapter.teacherHolder> {

    public TeacherAdapter(@NonNull FirebaseRecyclerOptions<Teacher> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull TeacherAdapter.teacherHolder holder, int position, @NonNull Teacher model) {
        holder.teacherDisplayNameTxt.setText(model.getDisplayName());
        holder.teacherEmailTxt.setText(model.getEmail());
    }

    @NonNull
    @Override
    public TeacherAdapter.teacherHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_teacher_list_item,parent,false);
        return new TeacherAdapter.teacherHolder(itemView);
    }

    public class teacherHolder extends RecyclerView.ViewHolder {
        TextView teacherDisplayNameTxt;
        TextView teacherEmailTxt;
        Button teacherEditBtn;
        Button teacherDeleteBtn;

        public teacherHolder(@NonNull View itemView) {
            super(itemView);

            teacherDisplayNameTxt = itemView.findViewById(R.id.teacherDisplayNameTxt);
            teacherEmailTxt = itemView.findViewById(R.id.teacherEmailTxt);
            teacherEditBtn = itemView.findViewById(R.id.teacherEditBtn);
            teacherDeleteBtn = itemView.findViewById(R.id.teacherDeleteBtn);

            teacherDeleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getRef(getAdapterPosition()).removeValue();
                }
            });

            teacherEditBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = getRef(getAdapterPosition()).getKey();
                    Intent i = new Intent(itemView.getContext(), TeacherEditAdminActivity.class);
                    i.putExtra("USER_ID", key);
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }
}
