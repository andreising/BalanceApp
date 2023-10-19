package com.andreisingeleytsev.balanceapp.domain.room.usecases

import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import com.andreisingeleytsev.balanceapp.domain.room.DiaryItemRepository
import javax.inject.Inject

class DeleteDiaryItemUseCase @Inject constructor(
    private val repository: DiaryItemRepository
) {
    suspend operator fun invoke(item: DiaryItem){
        repository.deleteItem(item)
    }
}