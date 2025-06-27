package com.example.a30daysapp.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysapp.R
import com.example.a30daysapp.data.PlayerRepositories
import com.example.a30daysapp.models.Player
import com.example.a30daysapp.ui.theme.ManchesterTheme

@Composable
fun ManchesterGallery(modifier: Modifier = Modifier) {
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    Scaffold { it ->
        AnimatedVisibility(
            visibleState = state,
            enter = fadeIn(
                animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
            ),
            exit = fadeOut(),
            modifier = modifier
        ) {
            LazyColumn(
                contentPadding = it
            ) {
                items(PlayerRepositories.players) {
                    PlayerItem(
                        player = it,
                        modifier = Modifier.padding(dimensionResource(R.dimen.pd_small))
                    )
                }
            }
        }
    }
}

@Composable
private fun PlayerItem(
    player: Player,
    modifier: Modifier = Modifier
) {
    var expandable by rememberSaveable { mutableStateOf(false) } // keep data consistently when activity has changed

    Card(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        onClick = {
            expandable = !expandable
        }
    ) {
        Column(modifier = Modifier.fillMaxWidth()
            .padding(dimensionResource(R.dimen.pd_small))
        ) {
            Text(
                text = stringResource(player.name),
                style = MaterialTheme.typography.titleLarge
            )

            PlayerImage(
                image = player.image,
                description = player.name,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.pd_medium)
                )
            )

            if (expandable) {
                Text(
                    text = stringResource(player.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
private fun PlayerImage(
    @DrawableRes image: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(image),
        contentDescription = stringResource(description),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.img_size))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.FillBounds
    )
}

@Preview(showBackground = true)
@Composable
private fun ManchesterGalleryPreview() {
    ManchesterTheme {
        ManchesterGallery()
    }
}