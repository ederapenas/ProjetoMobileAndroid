package br.unicap.c3.projetomobileandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DesenvolvedoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desenvolvedores)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        var btn_eder = findViewById<Button>(R.id.btn_eder)

        btn_eder.setOnClickListener{
            val intent = Intent(this, EderActivity::class.java)
            startActivity(intent)
        }
    }
}