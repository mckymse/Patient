package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThirdPage extends AppCompatActivity {
    int mHeight, mWidth;
    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float previousX;
    private float previousY;
    private ObjectAnimator ob1;
    private List<Float> results = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
//        WindowManager.LayoutParams layoutParams=getWindow().getAttributes();
//        layoutParams.screenBrightness=35/100.0f;
//        getWindow().setAttributes(layoutParams);
        mHeight = this.getResources().getDisplayMetrics().heightPixels;
        mWidth = this.getResources().getDisplayMetrics().widthPixels;
//        System.out.print(mHeight+" "+mWidth);
        initial();
    }

    protected void initial() {
        Log.i("infer", mHeight + "   " + mWidth);
        ImageView vw = findViewById(R.id.imageView3);
        Random rand = new Random();
        int yAxis = rand.nextInt(mHeight);
        int xAxis = rand.nextInt(mWidth);
        vw.setY(0f);
        vw.setX(xAxis);
        ob1 = ObjectAnimator.ofFloat(vw, "y", mHeight / 2);
        ob1.setDuration(4000);
        ob1.start();
//        System.out.println("Stage1");
//        vw.setX(((float) 100));
//        vw.setY((float) 500);
//        ob1 = ObjectAnimator.ofFloat(vw, "x", mWidth / 2);
//        ob1.setDuration(5000);
//        ob1.start();
//        System.out.println("Stage2");
//        ob1 = ObjectAnimator.ofFloat(vw, "y", mHeight / 2 );
//        ob1.setDuration(4000);
//        ob1.start();
//        vw.setY((float)mWidth);
//        vw.setX((float)xAxis);
//        System.out.println("Stage3");
//        vw.setX(5f);
//        yAxis = rand.nextInt(mHeight);
//        vw.setY((float)yAxis);
//        ob1 = ObjectAnimator.ofFloat(vw, "x", mHeight / 2);
//        ob1.setDuration(4000);
//        ob1.start();
//        System.out.println("Stage4");
    }

    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.
        // Log.i("motion","e: "+e);
        ImageView vw =  findViewById(R.id.imageView3);
        float x = e.getX();
        float y = e.getY();
        ob1.cancel();
        Toast.makeText(this,"Current co-ordinates: "+vw.getX() +" "+vw.getY(),Toast.LENGTH_LONG).show();
        results.add(x);
        results.add(y);
        return true;
    }
}
