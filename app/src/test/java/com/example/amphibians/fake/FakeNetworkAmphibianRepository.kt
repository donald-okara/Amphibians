package com.example.amphibians.fake

import com.example.amphibians.data.AmphibianDetailsRepository
import com.example.amphibians.model.Amphibian

class FakeNetworkAmphibianRepository : AmphibianDetailsRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibianList
    }

}