package br.sql1freitas.formulario_kotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.sql1freitas.formulario_kotlin.databinding.ActivityExibicaoBinding

class ExibicaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExibicaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExibicaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        binding.nome.text = i.extras?.getString("nome")
        binding.idade.text = i.extras?.getInt("idade").toString()
        binding.ocupacao.text = i.extras?.getString("ocupacao")
        binding.sexo.text = i.extras?.getString("sexo")

        binding.buttonEnviarDados.setOnClickListener {
            finish()
        }


    }
}