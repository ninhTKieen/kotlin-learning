package com.example.topicimage.data

import com.example.topicimage.models.Topic
import com.example.topicimage.R

object DataSource {
    val topics: List<Topic> = listOf<Topic>(
        Topic(R.string.architecture, R.drawable.architecture, 50),
        Topic(R.string.automotive, R.drawable.automotive, 40),
        Topic(R.string.biology, R.drawable.biology, 38),
        Topic(R.string.business, R.drawable.business, 60),
        Topic(R.string.crafts, R.drawable.crafts, 70),
        Topic(R.string.culinary, R.drawable.culinary, 80),
        Topic(R.string.design, R.drawable.design, 90),
        Topic(R.string.drawing, R.drawable.drawing, 100),
        Topic(R.string.ecology, R.drawable.ecology, 110),
        Topic(R.string.engineering, R.drawable.engineering, 6),
        Topic(R.string.fashion, R.drawable.fashion, 5),
        Topic(R.string.film, R.drawable.film, 15),
        Topic(R.string.finance, R.drawable.finance, 20),
        Topic(R.string.gaming, R.drawable.gaming, 25),
        Topic(R.string.geology, R.drawable.geology, 30),
        Topic(R.string.history, R.drawable.history, 130),
        Topic(R.string.journalism, R.drawable.journalism, 12),
        Topic(R.string.law, R.drawable.law, 46),
        Topic(R.string.lifestyle, R.drawable.lifestyle, 56),
        Topic(R.string.music, R.drawable.music, 50),
        Topic(R.string.painting, R.drawable.painting, 2),
        Topic(R.string.photography, R.drawable.photography, 30),
        Topic(R.string.physics, R.drawable.physics, 18),
        Topic(R.string.tech, R.drawable.tech, 10)
    )
}
