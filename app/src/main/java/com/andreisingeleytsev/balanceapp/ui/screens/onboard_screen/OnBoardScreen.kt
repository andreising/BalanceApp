package com.andreisingeleytsev.balanceapp.ui.screens.onboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreisingeleytsev.balanceapp.R
import com.andreisingeleytsev.balanceapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.balanceapp.ui.utils.BalanceAppFonts


@Composable
fun OnBoardScreen(viewModel: OnBoardScreenViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboard_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)))
        Column(
            Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(R.string.onboard_title), style = TextStyle(
                    color = Color.White, textAlign = TextAlign.Center,
                    fontFamily = BalanceAppFonts.font
                ))
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.finishOnBoard()
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor
                ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = stringResource(R.string.contin), style = TextStyle(
                        color = Color.White,
                        fontFamily = BalanceAppFonts.font
                    )
                )
            }
        }
    }
}