package br.sql1freitas.linearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {



    private lateinit var nomeAdapter: NomeAdapter
    private lateinit var editTextNome: EditText
    private lateinit var buttonAdicionar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonSortear: Button
    private lateinit var nomeSorteado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        editTextNome = findViewById(R.id.inserirNomes)
        buttonAdicionar = findViewById(R.id.botaoAdicionar)
        recyclerView = findViewById(R.id.recyclerView)
        buttonSortear = findViewById(R.id.botaoSortear)
        nomeSorteado = findViewById(R.id.nomeSorteado)


        nomeAdapter = NomeAdapter(mutableListOf())
        recyclerView.adapter = nomeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        buttonAdicionar.setOnClickListener {
            val nome = editTextNome.text.toString()
            if (nome.isNotEmpty()) {
                nomeAdapter.addNome(Nome(nome))
                editTextNome.text.clear()
                recyclerView.scrollToPosition(nomeAdapter.itemCount - 1)
            } else {
                Toast.makeText(this, "Por favor, digite um nome antes de adicionar.", Toast.LENGTH_SHORT).show()
            }
        }

        buttonSortear.setOnClickListener {
            if (nomeAdapter.itemCount > 0) {
                val randomIndex = Random.nextInt(nomeAdapter.itemCount)
                val sorteioNome = nomeAdapter.getNome(randomIndex)
                nomeSorteado.setText("${sorteioNome.nome}")
            } else {
                Toast.makeText(this, "A lista está vazia, adicione nomes antes de sortear.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}