package com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.edit_diary_screen

sealed class EditDiaryScreenEvent{
    data class OnTextChange(val text: String): EditDiaryScreenEvent()
    object OnConfirmChanges: EditDiaryScreenEvent()
    object OnCancelChanges: EditDiaryScreenEvent()
}
