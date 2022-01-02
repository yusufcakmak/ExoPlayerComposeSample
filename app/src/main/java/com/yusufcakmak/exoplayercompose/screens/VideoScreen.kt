package com.yusufcakmak.exoplayercompose.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import com.yusufcakmak.exoplayercompose.provideExoPlayer

@Composable
fun VideoScreen() {
    val playWhenReady by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val mediaItem = MediaItem.fromUri("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")
    val playerView = PlayerView(context)
    val player = provideExoPlayer(context = context, mediaItem = mediaItem)
    playerView.player = player
    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady
    }
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = {
                playerView
            }
        )
    }
}