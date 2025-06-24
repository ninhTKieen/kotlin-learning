package com.example.topicimage.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameRes: Int,
    @DrawableRes val imgRes: Int,
    val availableTopics: Int,
)
