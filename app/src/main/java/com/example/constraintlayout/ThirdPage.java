package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
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
        final Handler handler = new Handler();
        Log.i("infer", mHeight + "   " + mWidth);
        final ImageView targetView = findViewById(R.id.imageView3);
        mHeight = mHeight - 112;
        mWidth = mWidth - 50;
        final Random rand = new Random(100);
//        final int yAxis = rand.nextInt(2*mHeight)- mHeight;
//        final int xAxis = rand.nextInt(mWidth);

        targetView.setY(-mHeight);
        targetView.setX(rand.nextInt(mWidth));

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(targetView, "translationY", 0);
        animator1.setRepeatCount(0);
        animator1.setDuration(3000);
        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                // Call this method again, but with the two colors switched around.
                targetView.setY(rand.nextInt(mHeight));
                targetView.setX(mWidth);
            }
        });

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(targetView, "translationX", mWidth/2);
        animator2.setRepeatCount(0);
        animator2.setDuration(3000);
        animator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                // Call this method again, but with the two colors switched around.
                targetView.setY(mHeight);
                targetView.setX(rand.nextInt(mWidth));
            }
        });

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(targetView, "translationY", 0);
        animator3.setRepeatCount(0);
        animator3.setDuration(3000);
        animator3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                // Call this method again, but with the two colors switched around.
                targetView.setY(rand.nextInt(mHeight));
                targetView.setX(0);
            }
        });
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(targetView, "translationX", mWidth/2);
        animator4.setRepeatCount(0);
        animator4.setDuration(3000);

//sequencial animation
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2);
        set.play(animator2).before(animator3);
        set.play(animator3).before(animator4);
        set.start();
      //  set.start();
        //top - Bottom
//        vw.setY(yAxis);
//        vw.setX(2f);
//        ob1 = ObjectAnimator.ofFloat(vw, "x", mWidth / 2);
//        ob1.setDuration(4000);
//        ob1.start();

//     //Bottom - top
//        vw.setY(2000f);
//        vw.setX(500f);
//        ob1 = ObjectAnimator.ofFloat(vw, "y", mHeight / 2);
//        ob1.setDuration(4000);
//        ob1.start();
        //right - left
//        vw.setY(-500f);
//        vw.setX(1000f);
//        ob1 = ObjectAnimator.ofFloat(vw, "x",mWidth/2);
//        ob1.setDuration(4000);
//        ob1.start();
        //left-right
//        vw.setY(-500f);
//        vw.setX(0f);
//        ob1 = ObjectAnimator.ofFloat(vw, "x",mWidth/2);
//        ob1.setDuration(4000);
//        ob1.start();


    }

    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.
        // Log.i("motion","e: "+e);
        ImageView vw =  findViewById(R.id.imageView3);
        float x = e.getX();
        float y = e.getY();
        //ob1.cancel();
        Toast.makeText(this,"Current co-ordinates: "+vw.getX() +" "+vw.getY(),Toast.LENGTH_SHORT).show();
        results.add(x);
        results.add(y);
        System.out.println(results.toString());
        return true;
    }
}
