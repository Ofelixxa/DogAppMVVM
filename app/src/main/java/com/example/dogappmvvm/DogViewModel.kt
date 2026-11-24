package com.example.dogappmvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DogViewModel : ViewModel() {
    private val perros = listOf("Luna", "Max", "Nala", "Rocky")
    private var indice = 0

    var perro by mutableStateOf(perros[indice])
        private set

    fun cambiarPerro() {
        indice = (indice + 1) % perros.size
        perro = perros[indice]
    }
}
