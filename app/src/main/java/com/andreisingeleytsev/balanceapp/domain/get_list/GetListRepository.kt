package com.andreisingeleytsev.balanceapp.domain.get_list

interface GetListRepository {
    suspend fun getQuotesList(): List<String>
    suspend fun getTipsList(): List<String>
    suspend fun getImagesList(): List<Int>
}