package com.example.rain.fishingcard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    com.gc.materialdesign.views.ButtonRectangle startbtn, hScorebtn;


    SharedPreferences sharedPreferences;
    static public int highestScore;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("finshCarddata", MODE_WORLD_READABLE);
        highestScore = sharedPreferences.getInt("highestScore", 0);



        startbtn = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.startbtn);
        hScorebtn = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.hScorebtn);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                //startbtn.;
            }
        });

        hScorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "最高分： " + highestScore, Toast.LENGTH_SHORT).show();
                //startbtn.;
            }
        });

    }
}
