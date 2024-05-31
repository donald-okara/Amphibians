package com.example.amphibians.fake

import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.screens.AmphibianUiState
import com.example.amphibians.ui.screens.AmphibianViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class AmphibianViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibianViewModel_getAmphibians_verifyAmphibianUiStateSuccess() =  runTest {
        val amphibianViewModel = AmphibianViewModel(amphibianDetailsRepository = FakeNetworkAmphibianRepository()
        )
        assertEquals(
            AmphibianUiState.Success("Success: ${FakeDataSource.amphibianList.size} amphibians photos retrieved"),

        amphibianViewModel.amphibianUiState
        )
    }
}