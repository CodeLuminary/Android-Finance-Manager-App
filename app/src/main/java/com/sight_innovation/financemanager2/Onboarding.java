package com.sight_innovation.financemanager2;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Onboarding extends AppCompatActivity {

    private ViewPager viewPager; static Button btn;int pos = 0;
    private SlideAdapter myAdapter; static LinearLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        btn = (Button)findViewById(R.id.btn6);
        indicator = (LinearLayout)findViewById(R.id.indicator);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        myAdapter = new SlideAdapter(this);
        final Context activityContext = this;
        viewPager.setAdapter(myAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                if(pos == 2){
                    btn.setText("Got It");
                }
                else{
                    btn.setText("Skip");
                }
                setInd(position,activityContext);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    static void setInd(int position, Context context){
        for(int i = 0; i < 3; i++){
            ImageView imageView = (ImageView)indicator.getChildAt(i);
            if(i==position){
                imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ind_active));
            }
            else{
                imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ind_inactive));
            }
        }
        // btn.setText(btn.getText() + Integer.toString(position));
    }
}
