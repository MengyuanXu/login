package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    private Button Wifi;
    private Button DoorLock;
    private Button Temp;
    private Button Light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Defining Variables
        Wifi = (Button) findViewById(R.id.button3);
        DoorLock = (Button) findViewById(R.id.button4);
        Temp = (Button) findViewById(R.id.temp);
        Light = (Button) findViewById(R.id.light);

        //connect to door lock page
        DoorLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(Main3Activity.this, DoorLockActivity.class);
                startActivity(intent);
            }
        });

        //connect to wifi page
        Wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(Main3Activity.this, WifiActivity.class);
                startActivity(intent);
            }
        });

        Temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(Main3Activity.this, TempActivity.class);
                startActivity(intent);
            }
        });

        Light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(Main3Activity.this, LightActivity.class);
                startActivity(intent);
            }
        });

    }




}
