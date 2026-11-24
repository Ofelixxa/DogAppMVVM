package com.example.dogappmvvm

sealed interface DogUiState {
    data object Inicial : DogUiState
    data object Cargando : DogUiState
    data class Exito(val url: String) : DogUiState
    data class Error(val mensaje: String) : DogUiState
}