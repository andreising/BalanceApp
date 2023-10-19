package com.andreisingeleytsev.balanceapp.data.list_manager

import android.content.Context
import com.andreisingeleytsev.balanceapp.R
import com.andreisingeleytsev.balanceapp.common.ImagesList
import com.andreisingeleytsev.balanceapp.domain.get_list.GetListRepository


class ListManager(context: Context): GetListRepository {
    private val resources = context.resources
    override suspend fun getQuotesList(): List<String> {
        return resources.getStringArray(R.array.philosopher_quotes).toList()
    }

    override suspend fun getTipsList(): List<String> {
        return resources.getStringArray(R.array.peace_recommendations).toList()
    }

    override suspend fun getImagesList(): List<Int> {
        return ImagesList.list
    }

}