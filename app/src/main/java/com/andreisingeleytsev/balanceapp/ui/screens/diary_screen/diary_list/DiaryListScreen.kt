package com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.diary_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.balanceapp.R
import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import com.andreisingeleytsev.balanceapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.balanceapp.ui.utils.BalanceAppFonts
import com.andreisingeleytsev.balanceapp.ui.utils.UIEvent

@Composable
fun DiaryListScreen(
    viewModel: DiaryListScreenViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val diaryList = viewModel.diaryList.collectAsState(initial = emptyList())

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


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.diary_list), style = TextStyle(
                    color = Color.White,
                    fontFamily = BalanceAppFonts.font,
                    fontSize = 32.sp
                ), modifier = Modifier.padding(8.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            ) {
                items(diaryList.value) { item ->
                    DiaryListItem(
                        diaryItem = item,
                        onItemClick = { viewModel.onEvent(DiaryListScreenEvent.OnSelectItem(item)) },
                        onDeleteClick = { viewModel.onEvent(DiaryListScreenEvent.OnDeleteItem(item)) })
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(32.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FloatingActionButton(
                onClick = { viewModel.onEvent(DiaryListScreenEvent.OnBack) },
                containerColor = PrimaryColor
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            FloatingActionButton(
                onClick = { viewModel.onEvent(DiaryListScreenEvent.OnCreate) },
                containerColor = PrimaryColor
            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

    }
}

@Composable
fun DiaryListItem(diaryItem: DiaryItem, onItemClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(80.dp)
            .clickable {
                onItemClick.invoke()
            }, shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.diary_number) + ((diaryItem.id
                    ?: 0)).toString(), style = TextStyle(
                    color = Color.Black,
                    fontFamily = BalanceAppFonts.font,
                    fontSize = 12.sp
                ), modifier = Modifier.weight(1f)
            )
            Column(modifier = Modifier.weight(3f)) {
                Text(
                    text = diaryItem.dateOfCreation, style = TextStyle(
                        color = Color.Gray,
                        fontFamily = BalanceAppFonts.font,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = diaryItem.content, style = TextStyle(
                        color = Color.Black,
                        fontFamily = BalanceAppFonts.font,
                        fontSize = 16.sp
                    ), maxLines = 1
                )
            }
            IconButton(onClick = {
                onDeleteClick.invoke()
            }, modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}