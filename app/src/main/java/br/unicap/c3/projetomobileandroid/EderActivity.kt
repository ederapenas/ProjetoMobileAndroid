package br.unicap.c3.projetomobileandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.widget.Button
import android.widget.TextView

class EderActivity : AppCompatActivity() {

    private var pedidosAtual: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eder)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        var btn_pedido = findViewById<Button>(R.id.btn_pedido)

        btn_pedido.setOnClickListener{
            pedidosAtual++
            findViewById<TextView>(R.id.tv_pedidos).text = "Total de cliques: $pedidosAtual"
        }

    }
}