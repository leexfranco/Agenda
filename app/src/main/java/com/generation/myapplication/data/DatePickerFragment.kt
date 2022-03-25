package com.generation.myapplication.data

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DatePickerFragment(

private val TimePickerListener: TimePickerListener
): DialogFragment(), DatePickerDialog.OnDateSetListener

{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH
        )
        return DatePickerDialog(requireContext(), this, ano, mes, dia)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val calendario = Calendar.getInstance()
        calendario.set(Calendar.YEAR, p3)
        calendario.set(Calendar.MONTH, p2)
        calendario.set(Calendar.DAY_OF_MONTH, p1)
        TimePickerListener.TempoData(calendario.time.toInstant().atZone(
            ZoneId.systemDefault()).toLocalDate()
        )
    }
}

interface TimePickerListener{

    fun TempoData (date: LocalDate)
}