package com.generation.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.myapplication.adapter.TarefaAdapter
import com.generation.myapplication.model.Tarefa


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val listTarefa = mutableListOf(
            Tarefa(
                "Editar Documentos",
                "Fazer entre hoje e amanhã",
                "Letícia",
                "21/03/2022",
                true,
                "Serviços"


            ),
            Tarefa(
                "Curso .NET",
                "Começar nova linguagem",
                "Letícia",
                "26/03/2022",
                true,
                "Estudos"
            ),
            Tarefa(
                "Limpeza do 3º andar",
                "Lavar o banheiro e limpar o quarto",
                "Leticia",
                "26/03/2022",
                false,
                "Limpeza"
            )

        )

        val recyclerTarefa = view.findViewById<RecyclerView>(R.id.recyclerTarefa)

        val adapter = TarefaAdapter()

        recyclerTarefa.layoutManager = LinearLayoutManager(context)

        recyclerTarefa.adapter = adapter

        recyclerTarefa.serHasFixedSize(true)

        adapter.setLista(listTarefas)

        return view


    }
}