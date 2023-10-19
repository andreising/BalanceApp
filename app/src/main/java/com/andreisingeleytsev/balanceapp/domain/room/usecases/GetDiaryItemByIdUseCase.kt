package com.andreisingeleytsev.balanceapp.domain.room.usecases

import com.andreisingeleytsev.balanceapp.data.room.entities.DiaryItem
import com.andreisingeleytsev.balanceapp.domain.room.DiaryItemRepository
import javax.inject.Inject

class GetDiaryItemByIdUseCase @Inject constructor(
    private val repository: DiaryItemRepository
) {
    suspend operator fun invoke(diaryId: Int): DiaryItem{
        return repository.getItemById(diaryId)
    }
}