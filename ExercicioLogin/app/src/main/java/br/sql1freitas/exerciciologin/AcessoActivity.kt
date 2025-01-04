package br.sql1freitas.exerciciologin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.sql1freitas.exerciciologin.databinding.ActivityAcessoBinding

class AcessoActivity : AppCompatActivity() {

    private lateinit var acessoActivity : ActivityAcessoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        acessoActivity = ActivityAcessoBinding.inflate(layoutInflater)
        setContentView(acessoActivity.root)


        acessoActivity.buttonSair.setOnClickListener {
            finish()

        }

        }
    }
