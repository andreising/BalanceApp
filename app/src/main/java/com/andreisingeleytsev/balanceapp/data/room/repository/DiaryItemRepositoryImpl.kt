package com.andreisingeleytsev.balanceapp.data.room.repository

import com.andreisingeleytsev.balanceapp.data.room.dao.DiaryItemDao
import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import com.andreisingeleytsev.balanceapp.domain.room.DiaryItemRepository
import kotlinx.coroutines.flow.Flow

class DiaryItemRepositoryImpl(
    private val dao: DiaryItemDao
) : DiaryItemRepository {
    override suspend fun insertItem(item: DiaryItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: DiaryItem) {
        dao.deleteItem(item)
    }

    override fun getItems(): Flow<List<DiaryItem>> {
        return dao.getItems()
    }

    override suspend fun getItemById(id: Int): DiaryItem {
        return dao.getItemById(id)
    }


}