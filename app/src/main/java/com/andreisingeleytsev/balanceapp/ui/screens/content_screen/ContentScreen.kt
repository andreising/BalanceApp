package com.andreisingeleytsev.balanceapp.ui.screens.content_screen

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.balanceapp.R
import com.andreisingeleytsev.balanceapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.balanceapp.ui.utils.BalanceAppFonts

@Composable
fun ContentScreen(navHostController: NavHostController, viewModel: ContentScreenViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = viewModel.image.value),
            contentDescription = null,
            Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)))
        Column(modifier = Modifier.align(Alignment.Center).padding(horizontal = 8.dp)) {
            Text(
                text = viewModel.text.value, style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = BalanceAppFonts.font,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.onNextPressed()
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor
                ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = stringResource(R.string.next), style = TextStyle(
                        color = Color.White,
                        fontFamily = BalanceAppFonts.font
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navHostController.popBackStack()
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor
                ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = stringResource(R.string.back), style = TextStyle(
                        color = Color.White,
                        fontFamily = BalanceAppFonts.font
                    )
                )
            }
        }
    }
}