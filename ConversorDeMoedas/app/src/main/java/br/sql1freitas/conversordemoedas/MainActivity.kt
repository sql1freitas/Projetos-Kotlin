package br.sql1freitas.conversordemoedas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.sql1freitas.conversordemoedas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.botaoConverter.setOnClickListener {
           val valor = binding.valor.text.toString().toDouble()
           val resultado: String = (valor*6.30).toString()

           binding.textoResultado.setText("$" + resultado )
       }

        }
    }