package com.generation.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.myapplication.model.Categoria
import com.generation.myapplication.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate


@HiltViewModel
class MainViewModel @Inject constructor (
    val repository: Repository
        ) : ViewModel() {

            private var _responseListCategoria = MutableLiveData<Response<List<Categoria>>>()

            val responseListCategoria: LiveData<Response<List<Categoria>>> = _responseListCategoria

            val dataSelecionada = MutableLiveData<LocalDate>

            init {
                dataSelecionada.value = LocalDate.now()
                listCategoria()
            }


            fun listCategoria(){

                viewModelScope.launch {
                    try {
                        val response = repository.listCategoria()
                        _responseListCategoria.value = response

                    }catch (e: Exception){

                        Log.d("Erro", e.message.toString())

                }

                }
                }
            }
