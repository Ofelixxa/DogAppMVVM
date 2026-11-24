package com.example.dogappmvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val repository = DogRepository()

    var urlPerro by mutableStateOf("Sin consulta todavía")
        private set

    fun solicitarPerro() {
        viewModelScope.launch {
            try {
                urlPerro = repository.obtenerPerroRemoto().url
            } catch (e: Exception) {
                urlPerro = "Error al consultar el servicio"
            }
        }
    }
}