package com.example.exp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(this);

        btn2= (Button) findViewById(R.id.button2); btn2.setOnClickListener( this);
    }

    @Override
    public void onClick(View view) { if(view.equals(btn1))
    {
        Intent i1 = new Intent(this, XML_JSON.class); i1.putExtra("datatype","xml"); startActivity(i1);

    }
    else if(view.equals(btn2)) {
        Intent i1 = new Intent(this, XML_JSON.class); i1.putExtra("datatype","json"); startActivity(i1);
    }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

