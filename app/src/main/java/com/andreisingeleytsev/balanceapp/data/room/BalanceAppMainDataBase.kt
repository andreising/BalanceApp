package com.andreisingeleytsev.balanceapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import com.andreisingeleytsev.balanceapp.data.room.dao.DiaryItemDao

@Database(
    entities = [DiaryItem::class],
    version = 1
)
abstract class BalanceAppMainDataBase: RoomDatabase() {
    abstract val diaryItemDao: DiaryItemDao
}