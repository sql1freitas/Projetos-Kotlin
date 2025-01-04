package br.sql1freitas.exerciciologin

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.sql1freitas.exerciciologin.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {

    private lateinit var activityMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMain.root)


    activityMain.buttonLogin.setOnClickListener {

        val username = activityMain.editUsername.text.toString().trim()
        val password = activityMain.editPassword.text.toString().trim()

        if (username.equals("matheus") && password.equals("1234")) {
            Toast.makeText(applicationContext, "Acesso Permitido!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Dados Incorretos!", Toast.LENGTH_SHORT).show()
        }

        activityMain.editUsername.setText("")
        activityMain.editPassword.setText("")

    }



        }
    }
