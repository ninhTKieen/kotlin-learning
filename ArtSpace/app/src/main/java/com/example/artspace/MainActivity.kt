package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceScreen(
                        name = "Android",
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(name: String, modifier: Modifier = Modifier) {
    var currentIdx by remember { mutableIntStateOf(0) }

    val player = players[currentIdx]
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val imgHeight = screenHeight * 0.7f
    val shape = RoundedCornerShape(16.dp)

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = modifier
                .height(imgHeight.dp)
                .border(
                    border = BorderStroke(width = 1.dp, color = Color(0xFFFFEED4)),
                    shape = RoundedCornerShape(16.dp))
                .shadow(
                    elevation = 10.dp,
                    ambientColor = Color.Yellow,
                    spotColor = Color(0xFFDA291C),
                    shape = shape
                )
                .clip(shape = shape)
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(player.imgResId),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(Modifier.weight(1F))

        Text(
            text = player.name,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.man_red),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = player.years,
            modifier = Modifier.padding(top = 8.dp),
            color = colorResource(R.color.man_red),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(R.string.total_goals, player.goals),
            modifier = Modifier.padding(top = 8.dp),
            fontStyle = FontStyle.Italic,
            color = colorResource(R.color.man_red),
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            modifier = Modifier.padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentIdx = getPreviousIndex(currentIdx)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDA291C),
                    contentColor = Color.White
                ),
                modifier = Modifier.width(130.dp)
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    currentIdx = getNextIndex(currentIdx)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDA291C),
                    contentColor = Color.White
                ),
                modifier = Modifier.width(130.dp)
            ) {
                Text("Next")
            }
        }
    }
}

private fun getPreviousIndex(currentIndex: Int): Int {
    val maxIndex = players.lastIndex
    return if (currentIndex > 0) {
        currentIndex - 1;
    } else {
        maxIndex
    }
}

private fun getNextIndex(currentIndex: Int): Int {
    val maxIndex = players.lastIndex

    return if (currentIndex < maxIndex) {
        currentIndex + 1;
    } else {
        0
    }
}

data class Players(
    val name: String,
    val years: String,
    val goals: Int,
    val imgResId: Int,
)

val players = listOf(
    Players(
        name = "Wayne Rooney",
        years = "2004 - 2017",
        goals = 253,
        imgResId = R.drawable.rooney
    ),
    Players(
        name = "Sir Bobby Charlton",
        years = "1956 – 1973",
        goals = 249,
        imgResId = R.drawable.sir_bobby
    ),
    Players(
        name = "Ryan Giggs",
        years = "1991 - 2016",
        goals = 160,
        imgResId = R.drawable.ryan_giggs,
    ),
    Players(
        name = "Cristiano Ronaldo",
        years = "2003 - 2009 & 2021 - 2022",
        goals = 145,
        imgResId = R.drawable.ronaldo
    ),
    Players(
        name = "Denis Law",
        years = "1962 - 1973",
        goals = 237,
        imgResId = R.drawable.denis_law
    ),
    Players(
        name = "King Eric Cantona",
        years = "1992 - 1997",
        goals = 82,
        imgResId = R.drawable.king_eric
    ),
    Players(
        name = "Ruud Van Nistelrooy",
        years = "2001 - 2006",
        goals = 150,
        imgResId = R.drawable.ruud
    ),
    Players(
        name = "RVP 20 - Robin Van Persie",
        years = "2012 - 2015",
        goals = 48,
        imgResId = R.drawable.persie
    ),
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen("Android")
    }
}