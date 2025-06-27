package com.example.a30daysapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Player(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
)
