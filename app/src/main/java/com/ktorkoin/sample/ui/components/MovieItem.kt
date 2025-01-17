package com.ktorkoin.sample.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ktorkoin.sample.data.model.Movie

@Composable
fun MovieItem(item: Movie) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item.imageUrl?.let {
            NetworkImage(
                modifier = Modifier.size(50.dp),
                url = it,
                contentScale = ContentScale.Crop
            )
        }

        item.name?.let { Text(text = it) }
    }
}