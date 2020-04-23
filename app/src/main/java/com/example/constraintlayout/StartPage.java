package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {
    Button b1;
    private IntentFilter mIntentFilter;//Button code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_page);
        b1 = findViewById(R.id.button2);
        //Button code
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(Intent.ACTION_MEDIA_BUTTON);
        mIntentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY + 1);
        registerReceiver(mReceiver, mIntentFilter);
        Log.i("tag", "Registered");
        //
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartPage.this, ThirdPage.class);
                startActivity(intent);
            }
        });
    }
        @Override
        public void onResume() {
            super.onResume();
            registerReceiver(mReceiver, mIntentFilter);
        }
        private BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {


                String intentAction = intent.getAction();
                if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
                    return;
                }
                KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
                if (event == null) {
                    return;
                }
                int action = event.getAction();
                if (action == KeyEvent.ACTION_UP) {
                 //   Toast.makeText("MainActivity.this","Your Message", Toast.LENGTH_LONG).show();
                    Log.i("values","wroking");
                }
                abortBroadcast();

            }

        };
        @Override
        protected void onPause() {
            unregisterReceiver(mReceiver);
            super.onPause();
        }

}
