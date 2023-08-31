package com.curso.android.app.practica.appmiguelmustafa.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.appmiguelmustafa.model.Comparador
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel : ViewModel() {

    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData<Comparador>()

    fun updateComparador(comparador: Comparador) {
        _comparador.value = comparador
    }

    }



