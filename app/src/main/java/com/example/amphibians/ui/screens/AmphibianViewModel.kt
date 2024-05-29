package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch
import java.io.IOException

class AmphibianViewModel : ViewModel() {
    var amphibianUiState : String by mutableStateOf("")
        private set

    init {
        getAmphibian()
    }

    private fun getAmphibian() {
        viewModelScope.launch {
            try {
                val listResult = AmphibianApi.retrofitService.getAmphibians()
                amphibianUiState = listResult
            } catch (e: IOException) {
                TODO("Not yet implemented")
            }
        }
    }
}