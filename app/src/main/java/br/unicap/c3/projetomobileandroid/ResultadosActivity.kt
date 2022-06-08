package br.unicap.c3.projetomobileandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val usuario = intent.getStringExtra(Constantes.USUARIO)
        findViewById<TextView>(R.id.tv_nome).text = usuario

        val respostasCorretas = intent.getIntExtra(Constantes.RESPOSTAS_CERTAS, 0)
        val totalRespostas = intent.getIntExtra(Constantes.TOTAL_PERGUNTAS, 10)

        findViewById<TextView>(R.id.tv_resultado).text = "Sua pontuação foi de $respostasCorretas de $totalRespostas!"

        val btn_finalizar = findViewById<Button>(R.id.btn_finalizar)
        btn_finalizar.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}