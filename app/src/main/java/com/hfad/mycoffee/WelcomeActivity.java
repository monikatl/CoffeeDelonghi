package com.hfad.mycoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeActivity extends AppCompatActivity {

    private static final int TIME = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        Starter starter = new Starter();
        starter.start();
    }

     private class Starter extends Thread {
        @Override
         public void run(){
            try{
                Thread.sleep(TIME);
            } catch (Exception exception){
                Log.e("SplashScreen", exception.getMessage());
            }
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            WelcomeActivity.this.startActivity(intent);
            WelcomeActivity.this.finish();
        }
     }
}
