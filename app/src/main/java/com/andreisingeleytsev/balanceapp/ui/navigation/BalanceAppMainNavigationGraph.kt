package com.andreisingeleytsev.balanceapp.ui.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.balanceapp.common.Constants
import com.andreisingeleytsev.balanceapp.ui.screens.content_screen.ContentScreen
import com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.diary_list.DiaryListScreen
import com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.edit_diary_screen.EditDiaryScreen
import com.andreisingeleytsev.balanceapp.ui.screens.home_screen.HomeScreen
import com.andreisingeleytsev.balanceapp.ui.screens.onboard_screen.OnBoardScreen
import com.andreisingeleytsev.balanceapp.ui.utils.Routes


@Composable
fun BalanceAppMainNavigationGraph(
    startDestination: String
) {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController, startDestination = startDestination,
        modifier = Modifier.background(Color.Transparent)
    ) {
        composable(Routes.ONBOARDING_SCREEN){
            OnBoardScreen()
        }
        composable(Routes.HOME_SCREEN){
            HomeScreen(navHostController = navHostController)
        }
        composable(Routes.CONTENT_SCREEN+"/{${Constants.INDEX}}"){
            ContentScreen(navHostController = navHostController)
        }
        composable(Routes.DIARY_LIST_SCREEN){
            DiaryListScreen(navHostController = navHostController)
        }
        composable(Routes.EDIT_DIARY_SCREEN+"/{${Constants.ID}}"){
            EditDiaryScreen(navHostController = navHostController)
        }
    }
}
