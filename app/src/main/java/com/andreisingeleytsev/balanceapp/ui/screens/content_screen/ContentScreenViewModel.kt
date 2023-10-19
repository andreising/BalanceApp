package com.andreisingeleytsev.balanceapp.ui.screens.content_screen


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.balanceapp.R
import com.andreisingeleytsev.balanceapp.common.Constants
import com.andreisingeleytsev.balanceapp.domain.get_list.usecases.GetImagesListUseCase
import com.andreisingeleytsev.balanceapp.domain.get_list.usecases.GetQuotesListUseCase
import com.andreisingeleytsev.balanceapp.domain.get_list.usecases.GetTipsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle?,
    private val getImagesListUseCase: GetImagesListUseCase,
    private val getQuotesListUseCase: GetQuotesListUseCase,
    private val getTipsListUseCase: GetTipsListUseCase
) : ViewModel() {
    private var stringList = listOf("")
    private var imagesList = listOf(R.drawable.onboard_bg)
    val text = mutableStateOf("")
    val image = mutableStateOf(R.drawable.onboard_bg)

    private fun setContents(){
        text.value = stringList.random()
        image.value = imagesList.random()
    }

    fun onNextPressed(){
        setContents()
    }

    init {
        viewModelScope.launch {
            savedStateHandle?.get<String>(Constants.INDEX)?.toInt()?.let { index ->
                when (index) {
                    0 -> stringList = getQuotesListUseCase.invoke()
                    1 -> stringList = getTipsListUseCase.invoke()
                }

            }
            imagesList = getImagesListUseCase.invoke()
            setContents()
        }
    }

}