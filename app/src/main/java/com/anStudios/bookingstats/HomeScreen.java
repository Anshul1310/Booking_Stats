package com.anStudios.bookingstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class HomeScreen extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
//        toolbar=findViewById(R.id.toolbarHome);

    }

    public void startcar(View view) {
        startActivity(new Intent(HomeScreen.this,StartCarActivity.class));
        overridePendingTransition(R.anim.slide_next, R.anim.slide_down);
    }

    public void recent(View view) {
        startActivity(new Intent(HomeScreen.this,RecentBookings.class));
        overridePendingTransition(R.anim.slide_next, R.anim.slide_down);
    }

}