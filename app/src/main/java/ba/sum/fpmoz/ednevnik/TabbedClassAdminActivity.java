package ba.sum.fpmoz.ednevnik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import ba.sum.fpmoz.ednevnik.ui.a.adapters.TabbedAdapter;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.classes.AddClassFragment;
import ba.sum.fpmoz.ednevnik.ui.a.fragments.classes.ListClassFragment;

public class TabbedClassAdminActivity extends AppCompatActivity {

    TabLayout layout;
    ViewPager pager;
    TabbedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_class_admin);
        setTitle("Administracija razreda");

        this.layout = findViewById(R.id.classTabLayout);
        this.pager = findViewById(R.id.classViewPager);

        this.adapter = new TabbedAdapter(getSupportFragmentManager(), 1);
        this.adapter.addFragment(
                new ListClassFragment(), "Prikaz svih razreda"
        );

        this.adapter.addFragment(
                new AddClassFragment(), "Dodavanje novog razreda"
        );

        this.pager.setAdapter(this.adapter);
        this.layout.setupWithViewPager(this.pager);
    }
}