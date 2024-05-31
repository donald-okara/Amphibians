package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApiService

interface AmphibianDetailsRepository {
    suspend fun getAmphibians() : List<Amphibian>
}

class NetworkAmphibianDetailsRepository(
        private val amphibianApiService: AmphibianApiService
    ) : AmphibianDetailsRepository {
        override suspend fun getAmphibians(): List<Amphibian> =amphibianApiService.getAmphibians()
    }