 package com.example.apprevisao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome:EditText = findViewById(R.id.edtNome)
        val edtEndereco:EditText = findViewById(R.id.edtEndereco)
        val edtBairro:EditText = findViewById(R.id.edtBairro)
        val edtCep:EditText = findViewById(R.id.edtCep)

        val btn:Button = findViewById(R.id.bntCadastrar)

        btn.setOnClickListener{
            val intent = Intent(this, RespostaActivity::class.java)
            startActivity(intent)

        }

    }
}