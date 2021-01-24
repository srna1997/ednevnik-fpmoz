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
import ba.sum.fpmoz.ednevnik.model.Classes;


public class ClassesAdapter  extends FirebaseRecyclerAdapter<Classes,ClassesAdapter.classHolder> {


    public ClassesAdapter(@NonNull FirebaseRecyclerOptions<Classes> options) {
        super(options);
    }



    @Override
    protected void onBindViewHolder(@NonNull classHolder holder, int position, @NonNull Classes model) {
            holder.classUidTxt.setText(model.getUid());
            holder.classNameTxt.setText(model.getName());
    }

    @NonNull
    @Override
    public classHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_class_list_item,parent,false);
        return new ClassesAdapter.classHolder(itemView);
    }


    public class classHolder extends RecyclerView.ViewHolder {
        TextView classUidTxt;
        TextView classNameTxt;
        Button classEditBtn;
        Button classDeleteBtn;
        public classHolder(@NonNull View itemView) {
            super(itemView);

            classUidTxt = itemView.findViewById(R.id.classIdTxt);
            classNameTxt = itemView.findViewById(R.id.classNameTxt);
            classEditBtn = itemView.findViewById(R.id.classEditBtn);
            classDeleteBtn = itemView.findViewById(R.id.classDeleteBtn);

            classDeleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getRef(getAdapterPosition()).removeValue();
                }
            });

           /* classEditBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = getRef(getAdapterPosition()).getKey();
                    Intent i = new Intent(itemView.getContext(), ClassEditAdminActivity.class);
                    i.putExtra("USER_ID", key);
                    itemView.getContext().startActivity(i);
                }
            });
            */

        }
    }

}
