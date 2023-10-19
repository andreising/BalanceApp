package com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.edit_diary_screen

import android.icu.util.LocaleData
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.balanceapp.common.Constants
import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import com.andreisingeleytsev.balanceapp.domain.room.usecases.GetDiaryItemByIdUseCase
import com.andreisingeleytsev.balanceapp.domain.room.usecases.InsertDiaryItemUseCase
import com.andreisingeleytsev.balanceapp.ui.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class EditDiaryScreenViewModel @Inject constructor(
    private val getDiaryItemByIdUseCase: GetDiaryItemByIdUseCase,
    private val insertDiaryItemUseCase: InsertDiaryItemUseCase,
    savedStateHandle: SavedStateHandle?
) : ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: EditDiaryScreenEvent) {
        when (event) {
            is EditDiaryScreenEvent.OnCancelChanges -> {
                sendUIEvent(UIEvent.OnBack)
            }

            is EditDiaryScreenEvent.OnConfirmChanges -> {
                viewModelScope.launch {
                    insertDiaryItemUseCase.invoke(
                        DiaryItem(
                            id = diaryItem?.id,
                            content = _content.value,
                            dateOfCreation = _date.value
                        )
                    )
                }
                sendUIEvent(UIEvent.OnBack)
            }

            is EditDiaryScreenEvent.OnTextChange -> {
                _content.value = event.text
            }
        }
    }

    private fun sendUIEvent(event: UIEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private var diaryItem: DiaryItem? = null

    private val _content = mutableStateOf("")
    val content: State<String> = _content

    private val _date = mutableStateOf("")
    val date: State<String> = _date

    private fun getCurrentDateString(): String{
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }
    init {
        savedStateHandle?.get<String>(Constants.ID)?.toInt()?.let {id->
            viewModelScope.launch {
                if (id!=-1) diaryItem = getDiaryItemByIdUseCase.invoke(id)
                diaryItem?.let {
                    _date.value = it.dateOfCreation
                    _content.value = it.content
                    return@launch
                }
                _date.value = getCurrentDateString()
            }
        }
    }
}