package com.example.jetpackcomposetest

import androidx.compose.material3.R



import android.text.Layout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class Artist {
    val image = com.example.jetpackcomposetest.R.drawable.ecce_homo_detalle
    val name = "Poncio Pilato"
    val lastSeenOnline = "Hace 2000 años"

}


var Artista= Artist()




@Composable
fun ArtistCardColumn() {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}
@Composable
fun ArtistCardRow(artist: Artist) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
        Box{
            Image(
                painter = painterResource(id = com.example.jetpackcomposetest.R.drawable.ecce_homo_detalle),
                contentDescription = "Poncio Pilato")
            Icon(Icons.Filled.Favorite, contentDescription = "Call me maybe", tint = Color.Magenta)

        }


        Column {
            Text(artist.name, color = Color.Blue, style = MaterialTheme.typography.titleMedium)//, fontSize = 35.dp)
            Text(artist.lastSeenOnline, style = MaterialTheme.typography.titleMedium,color = Color.Blue)
        }
    }
}


@Preview
@Composable
fun PreviewMessageCard2() {
    ArtistCardRow(Artista)

}
