package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApi

interface AmphibianDetailsRepository {
    suspend fun getAmphibians() : List<Amphibian>

}

class NetworkAmphibianDetailsRepository() : AmphibianDetailsRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return AmphibianApi.retrofitService.getAmphibians()
    }
}