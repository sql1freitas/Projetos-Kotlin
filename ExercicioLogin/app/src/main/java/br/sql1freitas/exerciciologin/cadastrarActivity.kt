package br.sql1freitas.exerciciologin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.sql1freitas.exerciciologin.databinding.ActivityCadastrarBinding

class cadastrarActivity : AppCompatActivity() {


    private lateinit var cadastrarBinding: ActivityCadastrarBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        cadastrarBinding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(cadastrarBinding.root)

        cadastrarBinding.buttonRegistrar.setOnClickListener {

            val username = cadastrarBinding.setLogin.text.toString().trim()
            val password = cadastrarBinding.setPassword.text.toString().trim()

            if (username.isNotEmpty() or password.isNotEmpty()) {

                val novoUser = User(username, password)
                Toast.makeText(applicationContext, "Cadastro realizado!" , Toast.LENGTH_SHORT).show()

                Intent(this, MainActivity::class.java).apply {
                    putExtra("novoUser", novoUser)
                    startActivity(this)


                }
                finish()
            } else {
                Toast.makeText(applicationContext, "Informações inválidas!", Toast.LENGTH_SHORT).show()
            }







        }

        }
    }
