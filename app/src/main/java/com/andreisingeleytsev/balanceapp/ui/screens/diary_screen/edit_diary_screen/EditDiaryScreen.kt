package com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.edit_diary_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.balanceapp.R
import com.andreisingeleytsev.balanceapp.ui.utils.BalanceAppFonts
import com.andreisingeleytsev.balanceapp.ui.utils.UIEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDiaryScreen(
    viewModel: EditDiaryScreenViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
            when (it) {
                is UIEvent.OnBack -> {
                    navHostController.popBackStack()
                }

                is UIEvent.OnNavigate -> {
                    navHostController.navigate(it.route)
                }

                else -> {}
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .padding(5.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            TextField(
                modifier = Modifier.weight(1f),
                value = viewModel.content.value,
                onValueChange = { content ->
                    viewModel.onEvent(EditDiaryScreenEvent.OnTextChange(content))
                },
                label = {
                    Text(
                        text = stringResource(R.string.diary_title),
                        fontSize = 14.sp, style = TextStyle(
                            textAlign = TextAlign.Center
                        )
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Black,
                    containerColor = Color.White
                ),
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontFamily = BalanceAppFonts.font
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { viewModel.onEvent(EditDiaryScreenEvent.OnCancelChanges) }) {
                Text(text = stringResource(id = R.string.cancel))
            }
            Text(
                text = viewModel.date.value, style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontFamily = BalanceAppFonts.font
                )
            )
            TextButton(onClick = { viewModel.onEvent((EditDiaryScreenEvent.OnConfirmChanges)) }) {
                Text(text = stringResource(id = R.string.apply))
            }
        }
    }
}