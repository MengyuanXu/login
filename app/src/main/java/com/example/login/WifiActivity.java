package com.example.login;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class WifiActivity extends AppCompatActivity {

    WifiManager WifiManager;
    TextView WifiStatusTextView;
    Switch WifiSwitch;
    ImageView WifiOn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        //Defining Variables
        WifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiStatusTextView = (TextView) findViewById(R.id.textView);
        WifiSwitch = (Switch) findViewById(R.id.switch1);
        WifiOn = (ImageView) findViewById(R.id.WifiOn);

        /* Checking Wifi state
           If WIFI is enabled, display "Wifi is on" and set toggle button to on position
           If WIFI is disabled, display "Wifi is off" and set toggle button to off position
        */
        if(WifiManager.isWifiEnabled()){
            WifiStatusTextView.setText("WIFI is currently ON");
            WifiOn.setImageResource(R.drawable.ic_wifion);
            WifiSwitch.setChecked(true);
        }else{
            WifiStatusTextView.setText("WIFI is currently off");
            WifiOn.setImageResource(R.drawable.ic_wifioff);
            WifiSwitch.setChecked(false);
        }

        /*  Adds listener to toggle button
            If toggle is checked, wifi is enabled and "Wifi is on" is displayed
            If toggle is unchecked, wifi is enable and "Wifi is off" is displayed
         */
        WifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    WifiManager.setWifiEnabled(true);
                    WifiOn.setImageResource(R.drawable.ic_wifion);
                    WifiStatusTextView.setText("WIFI is currently ON");
                    Toast.makeText(WifiActivity.this, "WIFI may take a moment to turn on", Toast.LENGTH_LONG).show();
                }else {
                    WifiManager.setWifiEnabled(false);
                    WifiOn.setImageResource(R.drawable.ic_wifioff);
                    WifiStatusTextView.setText("WIFI is currently OFF");
                }
            }
        });
    }
}
