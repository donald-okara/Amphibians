package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.AmphibianDetailsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AmphibianUiState {
    data class Success(val amphibian: String) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}

class AmphibianViewModel(private val amphibianDetailsRepository: AmphibianDetailsRepository) : ViewModel() {
    var amphibianUiState : AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            amphibianUiState = AmphibianUiState.Loading
            amphibianUiState = try {
                val listResult = amphibianDetailsRepository.getAmphibians()
                //val listResult = AmphibianApi.retrofitService.getAmphibians()
                AmphibianUiState.Success(
                    "Success: ${listResult.size} amphibians photos retrieved"
                )
            } catch (e: IOException) {
                AmphibianUiState.Error
            } catch (e: HttpException) {
                AmphibianUiState.Error
            }
        }
    }

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibianDetailsRepository = application.container.amphibianDetailsRepository
                AmphibianViewModel(amphibianDetailsRepository = amphibianDetailsRepository)

            }
        }
    }
}