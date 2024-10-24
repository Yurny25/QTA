package com.example.qta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.TextView.SavedState
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DosMitadesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dos_mitades)



            val inputText: EditText = findViewById(R.id.input_dos)
            val button: Button = findViewById(R.id.btn_dos)
            val textResult: TextView = findViewById(R.id.resultado)
            
            button.setOnClickListener {     
                val text = inputText.text.toString()  
                val partes = dosMitades(text)
                textResult.text = partes
            }

        val btn_change_volver: Button = findViewById(R.id.button_volver)
        val btn_change_avanzar: Button = findViewById(R.id.button_avanzar)



        btn_change_volver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        btn_change_avanzar.setOnClickListener {
            val intent = Intent(this, DosPalabrasActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun dosMitades(text: String): String {
        val len = text.length
        val mid = len/2.toInt()

        val first = text.substring(0, mid)
        val second = text.substring(mid, len)

        return second+first
    }
}