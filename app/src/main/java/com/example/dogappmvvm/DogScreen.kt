package com.example.dogappmvvm

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DogScreen(vm: DogViewModel = viewModel()) {
    Column(
        Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(16.dp)
    ) {
        Text("Aplicación Dog")

        when (val e = vm.estado) {
            DogUiState.Inicial -> Text("Presiona Otro perro")
            DogUiState.Cargando -> Text("Consultando...")
            is DogUiState.Exito -> GlideImage(
                model = e.url,
                contentDescription = "Perro aleatorio",
                modifier = Modifier.fillMaxWidth()
            )
            is DogUiState.Error -> Text(e.mensaje)
        }

        Button(onClick = { vm.solicitarPerro() }) {
            Text("Otro perro")
        }
    }
}