package com.example.amphibians.fake

import com.example.amphibians.data.NetworkAmphibianDetailsRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkAmphibianRepositoryTest {
    @Test
    fun networkAmphibianRepository_getAmphibians_verifyList() = runTest {
        val repository = NetworkAmphibianDetailsRepository(
            amphibianApiService = FakeAmphibianApiService()
        )
        assertEquals(FakeDataSource.amphibianList, repository.getAmphibians())

    }
}