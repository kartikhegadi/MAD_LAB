package com.example.exp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnstart,btnstop;
    TextView txt;
    int counter=0;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button)findViewById(R.id.button);
        btnstart.setOnClickListener(this);
        btnstop=(Button)findViewById(R.id.button2);
        btnstop.setOnClickListener(this);
        txt=(TextView)findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(btnstart))
            counterstart();
        else if(view.equals(btnstop))
            counterstop();
    }
    private void counterstop() {
        this.running=false;
        btnstart.setEnabled(true);
        btnstop.setEnabled(false);
    }
    private void counterstart() {
        counter=0;running=true;
        new Mycounter().start();
        btnstart.setEnabled(false);
        btnstop.setEnabled(true);
    }
    Handler h= new Handler(Looper.getMainLooper())
    {
        public void handleMessage(Message msg)
        {
            txt.setText(String.valueOf(msg.what));
        }
    };
    class Mycounter extends Thread{
        public void run() {
            while (running) {
                counter++;
                h.sendEmptyMessage(counter);
                try {
                    Thread.sleep(1000);
                }
                catch(Exception e) {}
            }
        }
    }
}