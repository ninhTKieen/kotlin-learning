package com.example.affirmation.data

import com.example.affirmation.model.Affirmation
import com.example.affirmation.R

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.denis_law, R.drawable.denis_law),
            Affirmation(R.string.george_best, R.drawable.george_best),
            Affirmation(R.string.king_eric, R.drawable.king_eric),
            Affirmation(R.string.persie, R.drawable.persie),
            Affirmation(R.string.ronaldo, R.drawable.ronaldo),
            Affirmation(R.string.rooney, R.drawable.rooney),
            Affirmation(R.string.ruud, R.drawable.ruud),
            Affirmation(R.string.ryan_giggs, R.drawable.ryan_giggs),
            Affirmation(R.string.scholes, R.drawable.scholes),
            Affirmation(R.string.sir_bobby, R.drawable.sir_bobby)
        )
    }
}