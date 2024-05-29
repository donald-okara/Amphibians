package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            amphibianUiState.amphibian, modifier = modifier.fillMaxWidth())

        is AmphibianUiState.Loading -> LoadingScreen(modifier.padding(top = contentPadding.calculateTopPadding()))
        is AmphibianUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())

    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}
//
//@Composable
//fun ErrorHandlingScreen(exception: Exception, modifier: Modifier = Modifier) {
//    when (exception) {
//        is IOException -> IOExceptionScreen(modifier)
//        is SocketTimeoutException -> TimeoutExceptionScreen(modifier)
//        is SSLHandshakeException -> SSLHandshakeExceptionScreen(modifier)
//        else -> GeneralExceptionScreen(modifier)
//    }
//}
//
//
//@Composable
//fun IOExceptionScreen(modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier.fillMaxSize()
//    ) {
//        Image(
//            modifier = modifier.size(100.dp),
//            painter = painterResource(R.drawable.ic_connection_error),
//            contentDescription = stringResource(R.string.network_error)
//        )
//        Text(text = stringResource(id = R.string.network_error))
//    }
//}
//
//@Composable
//fun TimeoutExceptionScreen(modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier.fillMaxSize()
//    ) {
//        Image(
//            modifier = modifier.size(100.dp),
//            painter = painterResource(R.drawable.ic_connection_error),
//            contentDescription = stringResource(R.string.timeout_error)
//        )
//        Text(text = stringResource(id = R.string.timeout_error))
//    }
//}
//
//@Composable
//fun SSLHandshakeExceptionScreen(modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier.fillMaxSize()
//    ) {
//        Image(
//            modifier = modifier.size(100.dp),
//            painter = painterResource(R.drawable.ic_connection_error),
//            contentDescription = stringResource(R.string.ssl_error)
//        )
//        Text(text = stringResource(id = R.string.ssl_error))
//    }
//}
//
//@Composable
//fun GeneralExceptionScreen(modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier.fillMaxSize()
//    ) {
//        Image(
//            modifier = modifier.size(100.dp),
//            painter = painterResource(R.drawable.ic_connection_error),
//            contentDescription = stringResource(R.string.general_error)
//        )
//        Text(text = stringResource(id = R.string.general_error))
//    }
//}

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
){
    Column(
        modifier = modifier
    ) {
        Image(painter = painterResource(id = R.drawable.pic), contentDescription = "fghjkl")
        Text(text = photos)
    }
}