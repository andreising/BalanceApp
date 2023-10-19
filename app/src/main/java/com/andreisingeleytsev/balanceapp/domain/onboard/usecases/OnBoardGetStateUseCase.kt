package com.andreisingeleytsev.playingquizapp.domain.onboard.usecases

import com.andreisingeleytsev.balanceapp.domain.onboard.OnboardStateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnBoardGetStateUseCase @Inject constructor(
    private val repository: OnboardStateRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.getOnboardState()
    }
}