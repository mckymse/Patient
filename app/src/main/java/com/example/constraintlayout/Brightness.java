package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.SeekBar;
import android.widget.TextView;

public class Brightness extends AppCompatActivity {
    SeekBar sk;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness);
        sk=findViewById(R.id.sk1);
        t1=findViewById(R.id.tv1);

        int Brightness= Settings.System.getInt(getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,0);
        t1.setText(Brightness+"/255");


        sk.setProgress(Brightness);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Context context=getApplicationContext();
                boolean canWrite=Settings.System.canWrite(context);
                if(canWrite){
                    int sBrightness=i*255/255;
                    t1.setText(sBrightness+"/255");
                    Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS_MODE,Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                    Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,sBrightness);
                }
                else {
                    Intent intent=new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    context.startActivity(intent);
                }
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
