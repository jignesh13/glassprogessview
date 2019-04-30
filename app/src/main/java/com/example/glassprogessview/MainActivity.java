package com.example.glassprogessview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setProgess(View view) {
        VesselView glassView= findViewById(R.id.vesselview);
        Random random=new Random();
        glassView.setprogess(random.nextInt(101)/100.0f);
    }

}
