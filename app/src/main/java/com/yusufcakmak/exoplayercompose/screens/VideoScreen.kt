package com.yusufcakmak.exoplayercompose.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yusufcakmak.exoplayercompose.ui.theme.ExoPlayerComposeTheme

@Composable
fun VideoScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun VideoScreenPreview() {
    ExoPlayerComposeTheme {
        VideoScreen()
    }
}