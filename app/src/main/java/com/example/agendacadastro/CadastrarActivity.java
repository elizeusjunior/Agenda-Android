package com.example.agendacadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CadastrarActivity extends AppCompatActivity {
private EditText editTextNome, editTextEndereco, editTextTelefone;
private Button btnCadastrar, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        //referencias
        editTextNome = findViewById(R.id.editTextNomeCadastro);
        editTextEndereco= findViewById(R.id.editTextEndereco);
        editTextTelefone= findViewById(R.id.editTextTelefone);
        btnCadastrar = findViewById(R.id.buttonCadastrarCadastro);
        btnVoltar = findViewById(R.id.buttonVoltar);

    }

    public void onCadastrar(View view){
            if (!editTextNome.getText().toString().isEmpty() && !editTextEndereco.toString().isEmpty() && !editTextTelefone.toString().isEmpty()) {
                Contatos contatos = new Contatos(editTextNome.getText().toString(), editTextEndereco.getText().toString(), editTextTelefone.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("contatos", contatos);
                setResult(Activity.RESULT_OK, intent);
                Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }else Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

    }
    public void onVoltar(View view){
        finish();
    }
}