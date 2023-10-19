package com.andreisingeleytsev.balanceapp.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.balanceapp.R
import com.andreisingeleytsev.balanceapp.ui.theme.MainColor
import com.andreisingeleytsev.balanceapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.balanceapp.ui.utils.BalanceAppFonts
import com.andreisingeleytsev.balanceapp.ui.utils.Routes
import java.time.LocalDate


@Composable
fun HomeScreen(navHostController: NavHostController) {
    val today = LocalDate.now()
    val lazyRowList = mapOf(
        R.string.peace to R.drawable.img_6,
        R.string.balance to R.drawable.img_5,
        R.string.clarity to R.drawable.img_4,
        R.string.mercy to R.drawable.img_3
    ).toList()
    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_10),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)))
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(lazyRowList) { pair ->
                    Card(modifier = Modifier.padding(8.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(200.dp)
                        ) {
                            Image(
                                painter = painterResource(id = pair.second),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = Crop
                            )
                            Text(
                                text = stringResource(id = pair.first), style = TextStyle(
                                    color = Color.White,
                                    fontFamily = BalanceAppFonts.font
                                ), modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(2f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.start_screen), style = TextStyle(
                        color = Color.White,
                        fontFamily = BalanceAppFonts.font,
                        fontSize = 32.sp
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navHostController.navigate(Routes.CONTENT_SCREEN + "/0")
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor
                    ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text = stringResource(R.string.quotes), style = TextStyle(
                            color = Color.White,
                            fontFamily = BalanceAppFonts.font
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navHostController.navigate(Routes.CONTENT_SCREEN + "/1")
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor
                    ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text = stringResource(R.string.tips), style = TextStyle(
                            color = Color.White,
                            fontFamily = BalanceAppFonts.font
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navHostController.navigate(Routes.DIARY_LIST_SCREEN)
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor
                    ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text = stringResource(R.string.diary), style = TextStyle(
                            color = Color.White,
                            fontFamily = BalanceAppFonts.font
                        )
                    )
                }
                Card(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxSize(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
                        Image(
                            painter = painterResource(id = R.drawable.home_screen_card_img),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Column(Modifier.padding(horizontal = 24.dp)) {
                            Text(
                                text = stringResource(R.string.today_is), style = TextStyle(
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontFamily = BalanceAppFonts.font
                                )
                            )
                            Text(
                                text = today.dayOfMonth.toString() + " " + today.month,
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = BalanceAppFonts.font
                                )
                            )
                            Text(
                                text = today.dayOfWeek.name, style = TextStyle(
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontFamily = BalanceAppFonts.font
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}