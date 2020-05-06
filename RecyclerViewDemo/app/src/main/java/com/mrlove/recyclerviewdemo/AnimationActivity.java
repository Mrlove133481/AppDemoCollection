package com.mrlove.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        textView = findViewById(R.id.textView4);
        translationX();
        translationY();
    }
        public void translationX(){
            ObjectAnimator animator = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X,0,300f);
            animator.setDuration(1000);
            animator.setStartDelay(500);
            animator.start();
        }

        public void translationY(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView,View.TRANSLATION_Y,0,300f);
        animator.setDuration(1000);
        animator.start();
        }
}
