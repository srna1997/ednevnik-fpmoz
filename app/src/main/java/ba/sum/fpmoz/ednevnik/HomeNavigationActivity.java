package ba.sum.fpmoz.ednevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HomeNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}