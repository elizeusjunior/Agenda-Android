package com.example.agendacadastro;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private TextView textViewResultado;
private Button buttonCadastrar, buttonPesquisar, buttonMostrar;
private EditText editTextNome;
private List<Contatos> lista = new ArrayList<>(); //matriz dinâmica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referencias

        textViewResultado = findViewById(R.id.textViewResultado);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonPesquisar = findViewById(R.id.buttonPesquisar);
        buttonMostrar = findViewById(R.id.buttonMostrar);
        editTextNome = findViewById(R.id.editTextNome);

        //evento para abrir a activi de cadastro
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastrarActivity.class);
                textViewResultado.setText("");
                startActivityForResult(intent,1);
            }
        });

        //evento para mostrar a activi de mostrar
        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostrarActivity.class);
                intent.putExtra("lista", (Serializable) lista);
                textViewResultado.setText("");
                startActivity(intent);
            }
        });

    }
        //Método invocado qunado a activity for finalizada
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                //recuperar os dados
                lista.add((Contatos) data.getExtras().getSerializable("contatos"));
                //Toast.makeText(this, lista.get(0).mostrarDados(), Toast.LENGTH_SHORT).show();

            }
        }
    }
    //Em toda matriz (lista), em cada linha guardamos o objeto contato
    public void onPesquisar(View view){
        boolean achou = false;
        textViewResultado.setText("");
        for (Contatos contatos:lista) {
            if (editTextNome.getText().toString().equals(contatos.getNome())){
                textViewResultado.setText(contatos.mostrarDados());
                achou = true;
            }
        }
        editTextNome.setText("");
        if (!achou) Toast.makeText(this, "Preencha o campo nome!", Toast.LENGTH_SHORT).show();
    }

}