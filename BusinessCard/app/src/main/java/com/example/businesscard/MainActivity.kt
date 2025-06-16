package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.andrew_logo)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(color = 0xFF254D70)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "Card Logo",
                modifier = Modifier.width(180.dp),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = stringResource(R.string.card_name),
                fontSize = 30.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF131D4F),
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = stringResource(R.string.role),
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF131D4F),
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .width(IntrinsicSize.Max),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ContactRow(
                text = stringResource(R.string.phone),
                icon = Icons.Rounded.Phone
            )
            ContactRow(
                text = stringResource(R.string.account),
                icon = Icons.Rounded.AccountCircle
            )
            ContactRow(
                text = stringResource(R.string.mail),
                icon = Icons.Rounded.Email
            )
        }
    }
}

@Composable
fun ContactRow(text: String, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = Color(0xFF131D4F)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text (
            text = text,
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF131D4F)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard("Android")
    }
}