package com.example.amphibians.ui.screens
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibianUiState {
    data class Success(val amphibian: String) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}

class AmphibianViewModel : ViewModel() {
    var amphibianUiState : AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibian()
    }

    private fun getAmphibian() {
        viewModelScope.launch {
            try {
                val listResult = AmphibianApi.retrofitService.getAmphibians()
                amphibianUiState = AmphibianUiState.Success(
                    "Success: ${listResult.size} Amphibians received"
                )
            } catch (e: IOException) {
                amphibianUiState = AmphibianUiState.Error
            }
        }
    }
}