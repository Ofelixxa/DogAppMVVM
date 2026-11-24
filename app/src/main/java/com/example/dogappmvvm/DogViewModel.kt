package com.example.dogappmvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val repository = DogRepository()

    var estado by mutableStateOf<DogUiState>(DogUiState.Inicial)
        private set

    private fun esImagen(url: String): Boolean {
        val ruta = url.substringBefore("?").lowercase()
        return listOf(".jpg", ".jpeg", ".png", ".webp", ".gif").any { ruta.endsWith(it) }
    }

    fun solicitarPerro() {
        viewModelScope.launch {
            estado = DogUiState.Cargando
            try {
                val r = repository.obtenerPerroRemoto()
                estado = if (esImagen(r.url)) {
                    DogUiState.Exito(r.url)
                } else {
                    DogUiState.Error("Archivo no admitido")
                }
            } catch (e: Exception) {
                estado = DogUiState.Error("Error de conexión")
            }
        }
    }
}