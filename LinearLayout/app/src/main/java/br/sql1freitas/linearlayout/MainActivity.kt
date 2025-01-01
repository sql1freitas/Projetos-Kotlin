package br.sql1freitas.linearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var nomeAdapter: NomeAdapter
    private lateinit var editTextNome: EditText
    private lateinit var buttonAdicionar: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextNome = findViewById(R.id.inserirNomes)
        buttonAdicionar = findViewById(R.id.botaoAdicionar)
        recyclerView = findViewById(R.id.recyclerView)


        nomeAdapter = NomeAdapter(mutableListOf())
        recyclerView.adapter = nomeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        buttonAdicionar.setOnClickListener {
            val nome = editTextNome.text.toString()
            if (nome.isNotEmpty()) {
                nomeAdapter.addNome(Nome(nome))
                editTextNome.text.clear()
            } else {
                Toast.makeText(this, "Por favor, digite um nome antes de adicionar.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}