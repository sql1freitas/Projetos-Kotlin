package br.sql1freitas.formulario_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.sql1freitas.formulario_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.checkboxMasculino.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.checkboxFeminino.isChecked = false
            }
        }

        binding.checkboxFeminino.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.checkboxMasculino.isChecked = false
            }
        }

        binding.buttonEnviar.setOnClickListener {
            var nome = binding.editNome.text.toString()
            var idade = binding.editIdade.text.toString().toInt()
            var ocupacao = binding.editOcupacao.text.toString()
            var sexo = if (binding.checkboxMasculino.isChecked) "masculino" else "feminino"
            val i = Intent(this, ExibicaoActivity::class.java)

            i.putExtra("sexo", sexo)
            i.putExtra("nome", nome)
            i.putExtra("idade", idade)
            i.putExtra("ocupacao", ocupacao)



            startActivity(i)
        }
    }
    override fun onResume() {
        super.onResume()

        binding.editNome.text.clear()
        binding.editIdade.text.clear()
        binding.editOcupacao.text.clear()
        binding.checkboxMasculino.isChecked = false
        binding.checkboxFeminino.isChecked = false
    }
}