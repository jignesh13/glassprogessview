package com.example.glassprogessview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class HeartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
    }
    public void setProgess(View view) {
        HeartView heartView= findViewById(R.id.heart);
        Random random=new Random();
        heartView.setprogess(random.nextInt(101)/100.0f);
    }

}
