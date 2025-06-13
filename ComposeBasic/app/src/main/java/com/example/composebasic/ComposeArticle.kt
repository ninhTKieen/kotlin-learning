package com.example.composebasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
public fun ComposeArticleApp(modifier: Modifier = Modifier) {
    val imagePainter = painterResource(R.drawable.bg_compose_background)

    Column(modifier) {
        Image(
            painter = imagePainter,
            contentDescription = ""
        )

        Column {
            Text(
                text = stringResource(R.string.jet_header),
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(R.string.jet_first_content),
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(R.string.jet_second_content),
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}