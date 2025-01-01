package br.sql1freitas.linearlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NomeAdapter(private val nomes: MutableList<Nome>) : RecyclerView.Adapter<NomeAdapter.NomeViewHolder>() {

    class NomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNome: TextView = itemView.findViewById(R.id.textViewNome)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NomeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nome, parent, false)
        return NomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NomeViewHolder, position: Int) {
        val nome = nomes[position]
        holder.textViewNome.text = nome.nome
    }

    override fun getItemCount() = nomes.size

    fun addNome(nome: Nome) {
        nomes.add(nome)
        notifyItemInserted(nomes.size - 1)
    }
}