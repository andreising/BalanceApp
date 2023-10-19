package com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.diary_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.balanceapp.domain.room.usecases.DeleteDiaryItemUseCase
import com.andreisingeleytsev.balanceapp.domain.room.usecases.GetDiaryListUseCase
import com.andreisingeleytsev.balanceapp.ui.utils.Routes
import com.andreisingeleytsev.balanceapp.ui.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiaryListScreenViewModel @Inject constructor(
    private val deleteDiaryItemUseCase: DeleteDiaryItemUseCase,
    getDiaryListUseCase: GetDiaryListUseCase
) : ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: DiaryListScreenEvent) {
        when (event) {
            is DiaryListScreenEvent.OnDeleteItem -> {
                viewModelScope.launch {
                    deleteDiaryItemUseCase.invoke(event.diaryItem)
                }
            }

            is DiaryListScreenEvent.OnSelectItem -> {
                sendUIEvent(UIEvent.OnNavigate(Routes.EDIT_DIARY_SCREEN + "/${event.diaryItem.id}"))
            }

            is DiaryListScreenEvent.OnBack -> {
                sendUIEvent(UIEvent.OnBack)
            }

            is DiaryListScreenEvent.OnCreate -> {
                sendUIEvent(UIEvent.OnNavigate(Routes.EDIT_DIARY_SCREEN + "/-1"))
            }
        }
    }

    private fun sendUIEvent(event: UIEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    val diaryList = getDiaryListUseCase.invoke()

}