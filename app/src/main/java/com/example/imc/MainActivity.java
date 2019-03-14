package com.example.imc;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.imc.R.color.colorAccent;

public class MainActivity extends AppCompatActivity {

    EditText editPeso,editAltura;
    TextView txtPeso,txtClassificacao;
    Button btnCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.edit_peso);
        editAltura= findViewById(R.id.edit_altura);

        txtPeso = findViewById(R.id.txt_resultado_peso);
        txtClassificacao = findViewById(R.id.txt_resultado_classe);

        btnCalc = findViewById(R.id.btn_calculo);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarClassificacao();
            }
        });

    }


    public double calcularIMC(){

        double altura = Double.parseDouble(editAltura.getText().toString());
        double peso = Double.parseDouble(editPeso.getText().toString());
        if(altura<=0.5 || altura>2.5){
            editAltura.setText("Insira altura valida");


        }
        else if (peso<=2 || peso>450){
            editPeso.setText("Insira peso valido");

        }
        else {return  (peso/(altura*altura));
        }
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    public void verificarClassificacao (){
        try {
            txtPeso.setTextColor(R.color.color_green);
            txtPeso.setText(calcularIMC()+"  KG");

            if (calcularIMC()<16){
                txtClassificacao.setText("Magreza grave ");
            }
            else if (calcularIMC()>=16 && calcularIMC()<17){
                txtClassificacao.setText("Magreza moderada");
            }

            else if (calcularIMC()>=17 && calcularIMC()<18.5){
                txtClassificacao.setText("Magreza leve");
            }

            else if (calcularIMC()>=18.5 && calcularIMC()<25){
                txtClassificacao.setText("Saudavel");

            }

            else if (calcularIMC()>=25 && calcularIMC()<30){
                txtClassificacao.setText("Sobrepeso");

            }

            else if (calcularIMC()>=30 && calcularIMC()<35){
                txtClassificacao.setText("Obesidade garu I");

            }

            else if (calcularIMC()>=35 && calcularIMC()<40){
                txtClassificacao.setText("Obesidade garu II");

            }

            else if (calcularIMC()>=40){
                txtClassificacao.setText("Obesidade garu III");

            }

            editAltura.setText("");
            editPeso.setText("");
        }catch (Exception e){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
        }



}
