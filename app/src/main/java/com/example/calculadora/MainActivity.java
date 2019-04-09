package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtValor;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCE, btnSoma, btnDiminui, btnDivide, btnMultiplica, btnP, btnIgual, btnApaga;
    private boolean clicouOperador = false;
    private String Operacao = "=";
    private double valor1 = 0, valor2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    public void init(){
        txtValor = (TextView) findViewById(R.id.txtValor);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnCE = (Button) findViewById(R.id.btnCE);
        btnSoma = (Button) findViewById(R.id.btnSoma);
        btnDiminui = (Button) findViewById(R.id.btnDiminui);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnMultiplica = (Button) findViewById(R.id.btnMultiplica);
        btnP = (Button) findViewById(R.id.btnP);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnApaga = (Button) findViewById(R.id.btnApaga);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnP.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnApaga.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnSoma.setOnClickListener(this);
        btnMultiplica.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String resultado;
        resultado = txtValor.getText().toString();

        if(v == btn1 || v == btn0 || v == btn2 || v == btn3 ||v == btn4 || v == btn5 ||v == btn6 || v == btn7 || v == btn8 || v == btn9){
            if(clicouOperador){
              resultado = "0";
              clicouOperador = false;
            }
            switch (v.getId()){

                case R.id.btn0:
                    if(!resultado.equals("0"))
                        resultado = resultado.concat("0");

                    break;
                case R.id.btn1:
                    resultado = resultado.concat("1");

                    break;
                case R.id.btn2:
                    resultado = resultado.concat("2");

                    break;
                case R.id.btn3:
                    resultado = resultado.concat("3");

                    break;
                case R.id.btn4:
                    resultado = resultado.concat("4");

                    break;
                case R.id.btn5:
                    resultado = resultado.concat("5");

                    break;
                case R.id.btn6:
                    resultado = resultado.concat("6");

                    break;
                case R.id.btn7:
                    resultado = resultado.concat("7");

                    break;
                case R.id.btn8:
                    resultado = resultado.concat("8");

                    break;
                case R.id.btn9:
                    resultado = resultado.concat("9");

                    break;


            }

        }else if (v == btnSoma || v == btnDiminui || v == btnMultiplica || v == btnDivide){
            clicouOperador = true;

            if (valor1 == 0){
                valor1 = Double.parseDouble(resultado);
                Operacao = "+";
            }else{
                if(valor2 == 0){
                    valor2 = Double.parseDouble(resultado);

                    switch (v.getId()){
                        case R.id.btnSoma:
                            resultado = Double.toString(valor1 + valor2);
                            valor1 = Double.parseDouble(resultado);
                            Operacao = "+";
                            valor2 = 0;
                            break;

                        case R.id.btnDiminui:
                            resultado = Double.toString(valor1 - valor2);
                            valor1 = Double.parseDouble(resultado);
                            Operacao = "-";
                            valor2 = 0;
                            break;

                        case R.id.btnMultiplica:
                            resultado = Double.toString(valor1 * valor2);
                            valor1 = Double.parseDouble(resultado);
                            Operacao = "*";
                            valor2 = 0;
                            break;

                        case R.id.btnDivide:
                            resultado = Double.toString(valor1 / valor2);
                            valor1 = Double.parseDouble(resultado);
                            Operacao = "/";
                            valor2 = 0;
                            break;
                    }
                    Operacao  = ((Button)v).getText().toString();

                }
            }


        }
        else if (v == btnCE){
            resultado = "";
            valor2 = 0;
            valor1 = 0;
        }

        else if( v == btnIgual){

        }

        txtValor.setText(resultado);
    }
}
