package com.andreisingeleytsev.playingquizapp.ui.utils

object TimeConverter {
    operator fun invoke(long: Long): String{
        val timeInSeconds = long/1000
        val minutes = timeInSeconds / 60
        val seconds = timeInSeconds % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}