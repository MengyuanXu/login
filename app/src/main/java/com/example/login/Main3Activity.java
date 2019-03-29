package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    private Button Wifi;
    private Button DoorLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Wifi = (Button) findViewById(R.id.button3);
        DoorLock = (Button) findViewById(R.id.button4);

        DoorLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(Main3Activity.this, DoorLockActivity.class);
                startActivity(intent);
            }
        });

        Wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(Main3Activity.this, WifiActivity.class);
                startActivity(intent);
            }
        });

    }




}
