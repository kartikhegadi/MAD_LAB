package com.example.exp7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, TextToSpeech.OnInitListener {
    Button btn;
    EditText txt;
    TextToSpeech txttospeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(EditText) findViewById(R.id.editTextTextPersonName);
        btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        txttospeech=new TextToSpeech(getBaseContext(),this);
        txttospeech.setLanguage(Locale.ENGLISH);
    }
    @Override
    public void onClick(View view){
        String text=txt.getText().toString();
        txttospeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
    @Override
    public void onInit(int i) {
        if(i!=TextToSpeech.ERROR)

            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}