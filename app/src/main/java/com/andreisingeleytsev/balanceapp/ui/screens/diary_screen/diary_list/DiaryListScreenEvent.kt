package com.andreisingeleytsev.balanceapp.ui.screens.diary_screen.diary_list

import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem

sealed class DiaryListScreenEvent{
    data class OnDeleteItem(val diaryItem: DiaryItem): DiaryListScreenEvent()
    data class OnSelectItem(val diaryItem: DiaryItem): DiaryListScreenEvent()
    object OnBack: DiaryListScreenEvent()
    object OnCreate: DiaryListScreenEvent()
}
