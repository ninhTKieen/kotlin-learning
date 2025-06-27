package com.example.unscramble.ui.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import com.example.unscramble.R
import com.example.unscramble.ui.screens.game.components.FinalScoreDialog
import com.example.unscramble.ui.screens.game.components.GameLayout
import com.example.unscramble.ui.screens.game.components.GameStatus
import com.example.unscramble.ui.theme.UnscrambleTheme

@Composable
fun GameScreen(
    gameViewModel: GameViewModel = viewModel()
) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val (
        currentScrambledWord,
        currentWordCount,
        score,
        isGuessedWordWrong,
        isGameOver
    ) = gameUiState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = typography.displaySmall
        )

        GameLayout(
            currentWordCount = currentWordCount,
            currentScrambleWord = currentScrambledWord,
            isGuessWordWrong = isGuessedWordWrong,
            userGuess = gameViewModel.userGuess,
            onUserGuessChange = { gameViewModel.updateUserGuess(it) },
            onKeyboardDone = { gameViewModel.checkUserGuess() },
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(vertical = mediumPadding)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(mediumPadding)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    gameViewModel.checkUserGuess()
                }
            ) {
                Text(
                    text = stringResource(R.string.submit)
                )
            }
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    gameViewModel.skipWord()
                }
            ) {
                Text(
                    text = stringResource(R.string.skip)
                )
            }
        }

        GameStatus(score = score, modifier = Modifier.padding(mediumPadding))

        if (isGameOver) {
            FinalScoreDialog(
                score = score,
                onPlayAgain = {
                    gameViewModel.resetGame()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    UnscrambleTheme {
        GameScreen()
    }
}