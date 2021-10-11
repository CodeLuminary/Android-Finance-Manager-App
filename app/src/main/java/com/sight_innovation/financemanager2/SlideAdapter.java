package com.sight_innovation.financemanager2;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by SIGHT-INNOVATION on 11/10/2021.
 */

public class SlideAdapter extends PagerAdapter{
    Context context;
    LayoutInflater inflater;

    public  SlideAdapter(Context context){
        this.context = context;
    }

    public int[] lst_images = {
            R.drawable.onboard1,
            R.drawable.onboard2,
            R.drawable.onboad3
    };

    public String[] lst_title = {
            "SIMPLICITY", "OVERVIEW", "GROWTH"
    };

    public String[] lst_description = {
            "Handling & managing your money made simple",
            "Get an Overview of your finaces in a glance",
            "Experience superb financial growth with finance manager"
    };

    public int[] lst_background = {
            Color.rgb(255,255,255),
            Color.rgb(255,255,255),
            Color.rgb(255,255,255)
    };

    @Override
    public int getCount(){
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider,container,false);
        LinearLayout layoutslide = (LinearLayout)view.findViewById(R.id.lays);
        ImageView imgslide = (ImageView)view.findViewById(R.id.sliderImg);
        TextView txttitle = (TextView)view.findViewById(R.id.txttitle);
        TextView description = (TextView)view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_background[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText((lst_description[position]));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        //super.destroyItem(container,position,object);
        container.removeView((LinearLayout)object);
    }
}
