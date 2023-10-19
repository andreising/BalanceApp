package com.andreisingeleytsev.balanceapp.domain.onboard

import kotlinx.coroutines.flow.Flow

interface OnboardStateRepository {

    suspend fun onFinishedSave()

    fun getOnboardState(): Flow<Boolean>
}