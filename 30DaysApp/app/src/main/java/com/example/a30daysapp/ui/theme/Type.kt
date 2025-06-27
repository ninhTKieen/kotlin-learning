package com.example.a30daysapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.a30daysapp.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_thin, FontWeight.W100),
    Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
    Font(R.font.montserrat_extralight, FontWeight.W200),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_light, FontWeight.W300),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_regular, FontWeight.W400),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_medium, FontWeight.W500),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_semibold, FontWeight.W600),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_bold, FontWeight.W700),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extrabold, FontWeight.W800),
    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_black, FontWeight.W900)
)

val Typography = Typography(
    bodySmall = Typography().bodySmall.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
    ),
    bodyMedium = Typography().bodyMedium.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
    ),
    bodyLarge = Typography().bodyLarge.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
    ),
    labelSmall = Typography().labelSmall.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    labelMedium = Typography().labelMedium.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    labelLarge = Typography().labelLarge.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    titleSmall = Typography().titleSmall.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    titleMedium = Typography().titleMedium.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    titleLarge = Typography().titleLarge.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    headlineSmall = Typography().headlineSmall.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    headlineMedium = Typography().headlineMedium.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    headlineLarge = Typography().headlineLarge.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
    ),
    displaySmall = Typography().displaySmall.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
    ),
    displayMedium = Typography().displayMedium.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
    ),
    displayLarge = Typography().displayLarge.copy(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
    )
)