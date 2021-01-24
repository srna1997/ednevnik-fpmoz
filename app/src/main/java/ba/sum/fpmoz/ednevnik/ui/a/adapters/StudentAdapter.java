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
import ba.sum.fpmoz.ednevnik.UserEditAdminActivity;
import ba.sum.fpmoz.ednevnik.model.Student;

public class StudentAdapter  extends FirebaseRecyclerAdapter<Student,StudentAdapter.studentHolder> {

    public StudentAdapter(@NonNull FirebaseRecyclerOptions<Student> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull studentHolder holder, int position, @NonNull Student model) {
        holder.studentDisplayNameTxt.setText(model.getDisplayName());
        holder.studentEmailTxt.setText(model.getEmail());
    }

    @NonNull
    @Override
    public studentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_student_list_item,parent,false);
        return new StudentAdapter.studentHolder(itemView);
    }

    public class studentHolder extends RecyclerView.ViewHolder {
        TextView studentDisplayNameTxt;
        TextView studentEmailTxt;
        Button studentEditBtn;
        Button studentDeleteBtn;

        public studentHolder(@NonNull View itemView) {
            super(itemView);

            studentDisplayNameTxt = itemView.findViewById(R.id.studentDisplayNameTxt);
            studentEmailTxt = itemView.findViewById(R.id.studentEmailTxt);
            studentEditBtn = itemView.findViewById(R.id.studentEditBtn);
            studentDeleteBtn = itemView.findViewById(R.id.studentDeleteBtn);

            studentDeleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getRef(getAdapterPosition()).removeValue();
                }
            });

            studentEditBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = getRef(getAdapterPosition()).getKey();
                    Intent i = new Intent(itemView.getContext(), UserEditAdminActivity.class);
                    i.putExtra("USER_ID", key);
                    itemView.getContext().startActivity(i);
                }
            });
        }



    }
}
