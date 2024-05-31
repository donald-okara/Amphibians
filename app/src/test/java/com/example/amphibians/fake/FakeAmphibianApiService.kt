package com.example.amphibians.fake

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApiService

class FakeAmphibianApiService : AmphibianApiService {
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibianList
    }
}