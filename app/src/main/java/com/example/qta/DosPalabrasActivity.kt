package com.example.qta

import android.content.Intent
import android.hardware.biometrics.BiometricManager.Strings
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DosPalabrasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dos_palabras)

        val input_dosPalabras: EditText = findViewById(R.id.input_dosPalabras)
        val btn_dosPalabras: Button = findViewById(R.id.button_dos)
        val resultado_dos: TextView = findViewById(R.id.resultado_dos)

        val btn_volver: Button = findViewById(R.id.btn_volver)
        val btn_avanzar: Button = findViewById(R.id.btn_avanzar)


        btn_volver.setOnClickListener {
            val intent = Intent(this, DosMitadesActivity::class.java)
            startActivity(intent)
        }


        btn_avanzar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_dosPalabras.setOnClickListener {
            val text = input_dosPalabras.text.toString()
            val separados = dosPalabras(text)
            resultado_dos.text = separados.joinToString(" ")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun dosPalabras(text: String): List<String> {
        return text.split(",".toRegex()).reversed()
    }
}