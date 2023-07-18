package com.example.exp8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button save,call,clear; @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        ed=findViewById(R.id.editTextPhone);
        clear=findViewById(R.id.button);
        clear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ed.setText("");
        }
    });
        call=findViewById(R.id.button13);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=ed.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);

            }
        });

        String number=ed.getText().toString();
        Intent intent=new Intent(Intent.ACTION_DIAL); intent.setData(Uri.parse("tel:"+number)); startActivity(intent);

        save=findViewById(R.id.button15);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number= ed.getText().toString();
                Intent intent=new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);

                intent.putExtra(ContactsContract.Intents.Insert.PHONE,number); startActivity(intent);
            }
        });
    }
    public void inputNumber(View view)
    {
        Button btn=(Button)view;
        String digit=btn.getText().toString(); String phno=ed.getText().toString(); ed.setText(phno+digit);
    }



}
