package com.yusufcakmak.exoplayercompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.exoplayer2.MediaItem
import com.yusufcakmak.exoplayercompose.provideExoPlayer
import com.yusufcakmak.exoplayercompose.ui.theme.ExoPlayerComposeTheme

@Composable
fun RadioScreen() {
    val context = LocalContext.current
    val mediaItem = MediaItem.fromUri("http://kastos.cdnstream.com/1345_32")
    val player = provideExoPlayer(context = context, mediaItem = mediaItem)

    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = false
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 32.dp, end = 32.dp),
                onClick = {
                    player.playWhenReady = true
                }
            ) {
                Text(text = "Start")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 32.dp, end = 32.dp),
                onClick = {
                    player.playWhenReady = false
                }
            ) {
                Text(text = "Stop")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioScreenPreview() {
    ExoPlayerComposeTheme {
        RadioScreen()
    }
}