package br.sql1freitas.exerciciologin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.sql1freitas.exerciciologin.databinding.ActivityCadastrarBinding
import br.sql1freitas.exerciciologin.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {

    private lateinit var activityMain: ActivityMainBinding
    private lateinit var cadastrarBinding: ActivityCadastrarBinding

    private val listaUser = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMain.root)

        @Suppress("UNCHECKED_CAST")
     val newUser : User? = intent.extras?.getParcelable("novoUser")

        newUser?.let {
            listaUser.add(it)

        }

    activityMain.buttonLogin.setOnClickListener {

        val username = activityMain.editUsername.text.toString().trim()
        val password = activityMain.editPassword.text.toString().trim()

        val user = listaUser.find { it.login == username && it.password == password }

        if (user != null) {

            Toast.makeText(applicationContext, "Acesso aprovado!" , Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AcessoActivity::class.java))

        } else {

            Toast.makeText(applicationContext, "Dados inválidos!" , Toast.LENGTH_SHORT).show()

        }

        activityMain.editUsername.setText("")
        activityMain.editPassword.setText("")

    }

        activityMain.buttonCadastrar.setOnClickListener {
            startActivity(Intent(this,cadastrarActivity::class.java))
        }


        }
    }
