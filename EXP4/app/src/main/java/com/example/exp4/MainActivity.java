package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btn;
    boolean running;
    int[] img=new int[] {R.drawable.img1,R.drawable.img2,R.drawable.img3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(!running)
        {
            new Timer().schedule(new Mytimer(),0,3000);
            running=true;
        }
    }
    private class Mytimer extends TimerTask {
        @Override
        public void run() {
            try{
                WallpaperManager wm=WallpaperManager.getInstance(getBaseContext());
                Random rdm = new Random();

                wm.setBitmap(BitmapFactory.decodeResource(getResources(),img[rdm.nextInt(3)])
                );
            } catch(IOException E){}
        }
    }
}