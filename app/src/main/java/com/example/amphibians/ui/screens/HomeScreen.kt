package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.R

@Composable
fun HomeScreen(
    amphibianUiState : AmphibianUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when (amphibianUiState){
        is AmphibianUiState.Success -> ResultScreen(
            photos = amphibianUiState.amphibian, modifier.padding(top = contentPadding.calculateTopPadding())
        )
        is AmphibianUiState.Loading -> LoadingScreen(modifier.padding(top = contentPadding.calculateTopPadding()))
        is AmphibianUiState.Error -> ErrorScreen(modifier.padding(top = contentPadding.calculateTopPadding()))
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = modifier.size(100.dp),
            painter = painterResource(R.drawable.ic_connection_error),
            contentDescription = stringResource(R.string.error)
        )
        Text(text = stringResource(id = R.string.error))
    }

}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ResultScreen(
    photos : String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    Text(text = photos)
}