package com.example.topicimage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topicimage.data.DataSource
import com.example.topicimage.models.Topic
import com.example.topicimage.ui.theme.TopicImageTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopicImageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    TopicImageApp()
                }
            }
        }
    }
}

@Composable
fun TopicImageApp() {
    Surface(
        modifier = Modifier.fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = dimensionResource(R.dimen.pd_small))
    ) {
        TopicListGrid(
            topics = DataSource.topics,
            modifier = Modifier
        )
    }
}

@Composable
fun TopicListGrid(topics: List<Topic>, modifier: Modifier = Modifier) {
    val pdSmall = dimensionResource(R.dimen.pd_small)
    val navBarPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 100.dp)
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(pdSmall),
        horizontalArrangement = Arrangement.spacedBy(pdSmall),
        modifier = modifier,
        contentPadding = PaddingValues(
            bottom = navBarPadding,
            top = pdSmall,
        )
    ) {
        items(topics) { topic ->
            TopicImageCard(topic)
        }
    }
}

@Composable
fun TopicImageCard(topic: Topic, modifier: Modifier = Modifier) {
    val pdMedium = dimensionResource(R.dimen.pd_medium)
    val pdSmall = dimensionResource(R.dimen.pd_small)

    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(topic.imgRes),
                contentDescription = LocalContext.current.getString(topic.nameRes),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(horizontal = pdMedium)
            ) {
                Text(
                    text = stringResource(topic.nameRes), // can be used when app needs multiple languages
                    modifier = Modifier.padding(top = pdMedium),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = Modifier.padding(top = pdSmall),
                    horizontalArrangement = Arrangement.spacedBy(pdSmall), // gap
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = ""
                    )

                    Text(
                        text = topic.availableTopics.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopicImageTheme {
        TopicImageApp()
    }
}