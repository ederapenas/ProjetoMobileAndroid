package br.unicap.c3.projetomobileandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        var btn_pop = findViewById<Button>(R.id.btn_pop)
        var entrada_nome = findViewById<TextInputLayout>(R.id.entrada_nome)
        var btn_desenvolvedores = findViewById<Button>(R.id.btn_desenvolvedores)

        btn_pop.setOnClickListener{
            if(entrada_nome.toString().isEmpty()){
                Toast.makeText(this, "Por favor, informe seu nome", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, PerguntasQuizActivity::class.java)
                intent.putExtra(Constantes.USUARIO, entrada_nome.toString())
                startActivity(intent)
                finish()
            }

        }

        btn_desenvolvedores.setOnClickListener{
            val intent = Intent(this, DesenvolvedoresActivity::class.java)
            startActivity(intent)
        }
    }
}