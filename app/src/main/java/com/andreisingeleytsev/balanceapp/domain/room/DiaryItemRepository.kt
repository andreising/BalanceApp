package com.andreisingeleytsev.balanceapp.domain.room

import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import kotlinx.coroutines.flow.Flow

interface DiaryItemRepository {
    suspend fun insertItem(item: DiaryItem)
    suspend fun deleteItem(item: DiaryItem)
    fun getItems(): Flow<List<DiaryItem>>
    suspend fun getItemById(id: Int): DiaryItem
}