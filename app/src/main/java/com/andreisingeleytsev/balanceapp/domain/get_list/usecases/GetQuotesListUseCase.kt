package com.andreisingeleytsev.balanceapp.domain.get_list.usecases

import com.andreisingeleytsev.balanceapp.domain.get_list.GetListRepository
import javax.inject.Inject

class GetQuotesListUseCase @Inject constructor(
    private val repository: GetListRepository
) {
    suspend operator fun invoke(): List<String>{
        return repository.getQuotesList()
    }
}