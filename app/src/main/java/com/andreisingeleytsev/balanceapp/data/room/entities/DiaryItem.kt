package com.andreisingeleytsev.balanceapp.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andreisingeleytsev.balanceapp.common.Constants

@Entity(tableName = Constants.DIARY_TABLE_NAME)
data class DiaryItem(
    @PrimaryKey
    val id: Int? = null,
    val content: String,
    val dateOfCreation: String
)
