package ba.sum.fpmoz.ednevnik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import ba.sum.fpmoz.ednevnik.ui.a.adapters.TabbedAdapter;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.classes.AddClassFragment;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.classes.ListClassFragment;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.curses.AddCursesFragment;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.curses.ListCursesFragment;

public class TabbedCurseAdminActivity extends AppCompatActivity {

    TabLayout layout;
    ViewPager pager;
    TabbedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_curse);
        setTitle("Administracija predmeta");

        this.layout = findViewById(R.id.curseTabLayout);
        this.pager = findViewById(R.id.curseViewPager);

        this.adapter = new TabbedAdapter(getSupportFragmentManager(), 1);
        this.adapter.addFragment(
                new ListCursesFragment(), "Prikaz svih predmeta"
        );

        this.adapter.addFragment(
                new AddCursesFragment(), "Dodavanje novog predmeta"
        );

        this.pager.setAdapter(this.adapter);
        this.layout.setupWithViewPager(this.pager);
    }
}