package com.andreisingeleytsev.balanceapp.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreisingeleytsev.balanceapp.common.Constants
import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import kotlinx.coroutines.flow.Flow


@Dao
interface DiaryItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: DiaryItem)
    @Delete
    suspend fun deleteItem(item: DiaryItem)
    @Query("SELECT * FROM "+Constants.DIARY_TABLE_NAME)
    fun getItems(): Flow<List<DiaryItem>>
    @Query("SELECT * FROM "+Constants.DIARY_TABLE_NAME + " WHERE id IS :id")
    suspend fun getItemById(id: Int): DiaryItem
}