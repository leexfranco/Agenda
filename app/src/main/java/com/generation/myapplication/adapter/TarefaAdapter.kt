package com.generation.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generation.myapplication.R
import com.generation.myapplication.model.Tarefa

    class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var listTarefas = emptyList<Tarefa>()

    class TarefaViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textTarefa = view.findViewById<TextView>(R.id.textTarefa)
        val textDesc = view.findViewById<TextView>(R.id.textDesc)
        val textResp = view.findViewById<TextView>(R.id.textResp)
        val textData = view.findViewById<TextView>(R.id.textData)
        val switchAnd = view.findViewById<Switch>(R.id.switchAnd)
        val textCategoria = view.findViewById<TextView>(R.id.textCategoria)
        val buttonEx = view.findViewById<Button>(R.id.buttonEx)


    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
            val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_tarefa, parent, false)

            return TarefaViewHolder(layout)
        }

        override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
            val tarefaH = listTarefas [position]
            holder.textTarefa.text = tarefaH.nome
            holder.textDesc.text = tarefaH.descricao
            holder.textResp.text = tarefaH.responsavel
            holder.textData.text = tarefaH.data
            holder.switchAnd.isChecked = tarefaH.status
            holder.textCategoria.text = tarefaH.caregoria.descricao

        }

        override fun getItemCount(): Int {
            return listTarefas.size
        }

        fun setLista (lista: List<Tarefa>){
            listTarefas = lista
            notifyDataSetChanged()
        }
    }