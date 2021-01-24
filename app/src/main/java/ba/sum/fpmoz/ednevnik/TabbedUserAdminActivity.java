package ba.sum.fpmoz.ednevnik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import ba.sum.fpmoz.ednevnik.ui.a.adapters.TabbedAdapter;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.users.AddUsersFragment;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.users.ListStudentFragment;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.users.ListTeacherFragment;

public class TabbedUserAdminActivity extends AppCompatActivity {

    TabbedAdapter adapter;
    TabLayout layout;
    ViewPager pager;

   /* private User loggedUser;

    FirebaseUser user;
    FirebaseDatabase db;
    DatabaseReference refAdmin;
    DatabaseReference refTeacher;
    DatabaseReference refStudent;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_user_admin);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

/*
        user = FirebaseAuth.getInstance().getCurrentUser();
        db = FirebaseDatabase.getInstance();
        refAdmin = db.getReference("/ednevnik/admini").getRef().child(user.getUid());
        refTeacher = db.getReference("/ednevnik/nastavnici").getRef().child(user.getUid());
        refStudent = db.getReference("/ednevnik/ucenici").getRef().child(user.getUid());



        refAdmin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                loggedUser = snapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
        this.layout = findViewById(R.id.tabLayout);
        this.pager = findViewById(R.id.viewPager);

        this.adapter = new TabbedAdapter(getSupportFragmentManager(), 1);
        this.adapter.addFragment(
                new ListStudentFragment(), "Prikaz svih učenika"
        );
        this.adapter.addFragment(
                new ListTeacherFragment(), "Prikaz svih nastavnika"
        );
        this.adapter.addFragment(
                new AddUsersFragment(), "Dodavanje novih korisnika"
        );

/*
        this.adapter = new TabbedAdapter(getSupportFragmentManager(), 1);
        if (user.getEmail().equals(loggedUser.getEmail()))
        {
            this.adapter.addFragment(
                    new ListStudentFragment(), "Prikaz svih učenika"
            );
            this.adapter.addFragment(
                    new AddUsersFragment(), "Dodavanje novih korisnika"
            );
        }else
        {
            this.adapter.addFragment(
                    new ListStudentFragment(), "Prikaz svih učenika"
            );
        }
*/

        this.pager.setAdapter(this.adapter);
        this.layout.setupWithViewPager(this.pager);
    }
}