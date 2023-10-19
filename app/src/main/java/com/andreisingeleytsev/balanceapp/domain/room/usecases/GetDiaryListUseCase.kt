package com.andreisingeleytsev.balanceapp.domain.room.usecases

import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import com.andreisingeleytsev.balanceapp.domain.room.DiaryItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDiaryListUseCase @Inject constructor(
    private val repository: DiaryItemRepository
) {
    operator fun invoke(): Flow<List<DiaryItem>>{
        return repository.getItems()
    }
}