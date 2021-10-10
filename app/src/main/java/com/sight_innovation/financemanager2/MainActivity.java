package com.sight_innovation.financemanager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This delay is to make the splash show longer
        try{
            Thread.sleep(2000);
        }catch(Exception e){}

        sharedPreferences = this.getSharedPreferences("HTTP_HELPER_PREFS", Context.MODE_PRIVATE);

        if(!sharedPreferences.getBoolean("isGotten",false)){
            Onboarding onboarding = new Onboarding();
        }
        else{
            if(!sharedPreferences.getBoolean("isLogin",false)) {
                //Show login screen(activity);

            }
            else{
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            //.getSupportFragmentManager().beginTransaction().replace(R.id.layout_container2,thFrag,"Communication").addToBackStack(null).commit();

        }
    }
}
