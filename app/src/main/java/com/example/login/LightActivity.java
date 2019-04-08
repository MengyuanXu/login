package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class LightActivity extends AppCompatActivity {

    TextView tv_light;
    SeekBar seekBar2;
    double l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        tv_light = (TextView) findViewById(R.id.tv_light);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setMax(100);

        l=seekBar2.getMax()-100;
        tv_light.setText(String.format(Locale.getDefault(), "%.1f",l));

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                l = progress;
                tv_light.setText(String.format(Locale.getDefault(), "%.1f",l));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
