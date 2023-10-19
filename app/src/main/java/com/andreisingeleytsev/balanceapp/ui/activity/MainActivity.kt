package com.andreisingeleytsev.balanceapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andreisingeleytsev.balanceapp.ui.navigation.BalanceAppMainNavigationGraph
import com.andreisingeleytsev.balanceapp.ui.theme.MainColor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MainColor) {
                if (!viewModel.isLoading.value) BalanceAppMainNavigationGraph(
                    startDestination = viewModel.startDestination.value!!
                )
            }
        }
    }
}

