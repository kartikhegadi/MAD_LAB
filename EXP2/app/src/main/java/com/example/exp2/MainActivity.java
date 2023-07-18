package com.example.exp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnc;
    Button btnadd,btnsub,btnmul,btndiv,btneq,btndot;
    EditText txtresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2=(Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3=(Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4=(Button) findViewById(R.id.button21);
        btn4.setOnClickListener(this);
        btn5=(Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6=(Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7=(Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8= (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9=(Button) findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btn0=(Button) findViewById(R.id.button14);
        btn0.setOnClickListener(this);
        btnc=(Button) findViewById(R.id.button17);
        btnc.setOnClickListener(this);
        btnadd=(Button) findViewById(R.id.button16);
        btnadd.setOnClickListener(this);
        btnsub=(Button) findViewById(R.id.button12);
        btnsub.setOnClickListener(this);
        btnmul=(Button) findViewById(R.id.button20);
        btnmul.setOnClickListener(this);
        btndiv=(Button) findViewById(R.id.button4);
        btndiv.setOnClickListener(this);
        btndot=(Button) findViewById(R.id.button13);
        btndot.setOnClickListener(this);
        btneq=(Button) findViewById(R.id.button15);
        btneq.setOnClickListener(this);
        txtresult=(EditText) findViewById(R.id.textbox);
        txtresult.setText("");
    }
    @Override
    public void onClick(View view) {
        if(view.equals(btn1))
            txtresult.append("1");
        if(view.equals(btn2))
            txtresult.append("2");
        if(view.equals(btn3))
            txtresult.append("3");
        if(view.equals(btn4))
            txtresult.append("4");
        if(view.equals(btn5))
            txtresult.append("5");
        if(view.equals(btn6))
            txtresult.append("6");
        if(view.equals(btn7))
            txtresult.append("7");
        if(view.equals(btn8))
            txtresult.append("8");
        if(view.equals(btn9))
            txtresult.append("9");
        if(view.equals(btn0))
            txtresult.append("0");
        if(view.equals(btndot))
            txtresult.append(".");
        if(view.equals(btnadd))
            txtresult.append("+");
        if(view.equals(btnsub))
            txtresult.append("-");
        if(view.equals(btnmul))
            txtresult.append("*");
        if(view.equals(btndiv))
            txtresult.append("/");
        if(view.equals(btnc))
            txtresult.setText("");
        if(view.equals(btneq))
            try {
                String data=txtresult.getText().toString();
                if(data.contains("/")) {
                    divide(data);
                }else if(data.contains("*")) {
                    multiplication(data);
                } else if(data.contains("+")) {
                    addition(data);
                } else if(data.contains("-")) {
                    subtraction(data);
                }
            }
            catch (Exception e){
                displayInvalidMessage("Invalid operator");
            }
    }
    private void displayInvalidMessage(String nes) {
        Toast.makeText(getBaseContext(),nes,Toast.LENGTH_LONG).show();
    }

    private void divide(String data) {
        String[] operands = data.split(Pattern.quote("/"));
        if (operands.length == 2) {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 / operand2;
            txtresult.setText(String.valueOf(data.valueOf(result)));
        }
    }

    private void multiplication(String data) {
        String[] operands = data.split(Pattern.quote("*"));
        if (operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1*operand2;
            txtresult.setText(String.valueOf(data.valueOf(result)));
        }
    }
    private void addition(String data) {
        String[] operands = data.split(Pattern.quote("+"));
        if (operands.length == 2) {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 + operand2;
            txtresult.setText(String.valueOf(data.valueOf(result)));
        }
    }
    private void subtraction(String data) {
        String[] operands = data.split("-");
        if (operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1-operand2;
            txtresult.setText(String.valueOf(data.valueOf(result)));
        }
    }
}
