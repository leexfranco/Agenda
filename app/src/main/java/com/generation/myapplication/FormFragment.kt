package com.generation.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.myapplication.data.DatePickerFragment
import com.generation.myapplication.data.TimePickerListener
import com.generation.myapplication.databinding.FragmentFormBinding
import com.generation.myapplication.model.Categoria
import java.time.LocalDate

class FormFragment : Fragment(), TimePickerListener {

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentFormBinding

    override fun TempoData(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }

    fun spinnerCategorias (categoria: List<Categoria>?){

        if (categoria != null) {
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                categoria

            )
        }
    }

           override fun onCreateView(
               inflater: LayoutInflater, container: ViewGroup?,
               savedInstanceState: Bundle?,
           ): View {

               binding = FragmentFormBinding.inflate(layoutInflater, container, false)

               binding.buttonSalvar.setOnClickListener {
                   findNavController().navigate(R.id.action_formFragment2_to_listFragment)}

               binding.editData.setOnClickListener {
                   DatePickerFragment(this).show(parentFragmentManager, "Date Picker")
               }

               mainViewModel.responseListCategoria.observe(
                   viewLifecycleOwner,
                   { response ->
                       Log.d("Requisição", response.body().toString())
                       spinnerCategorias(response.body())
                   })

               mainViewModel.dataSelecionada.observe(
                   viewLifecycleOwner,
                   { selectedDate -> binding.editData.setText(selectedDate.toString())
                   })


               return binding.root
           }
       }
