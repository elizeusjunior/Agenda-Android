package com.example.agendacadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MostrarActivity extends AppCompatActivity {
private TextView textViewResutladoMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        //referencias
        textViewResutladoMostrar = findViewById(R.id.textViewResultadoMostrar);

        //recuperando dados
        Bundle dados = getIntent().getExtras();
        List<Contatos> lista = (List<Contatos>) dados.getSerializable("lista");
        //mosrar contatos
        textViewResutladoMostrar.setText("Lista de Contatos\n");
        for (Contatos contatos:lista) {
            textViewResutladoMostrar.append(contatos.mostrarDados());
        }
    }

    public void onVoltar(View view){
        finish();
    }
}