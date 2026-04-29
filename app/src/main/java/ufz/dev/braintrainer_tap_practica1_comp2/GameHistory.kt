package ufz.dev.braintrainer_tap_practica1_comp2

import java.util.Date

data class GameRecord(
    val score: Int,
    val difficulty: String,
    val date: Date
)

object HistoryManager {
    val records = mutableListOf<GameRecord>()

    fun addRecord(score: Int, difficulty: String) {
        records.add(GameRecord(score, difficulty, Date()))
    }

    fun getAverageTotal(): Double {
        if (records.isEmpty()) return 0.0
        return records.map { it.score }.average()
    }

    fun getAverageByDifficulty(difficulty: String): Double {
        val filtered = records.filter { it.difficulty == difficulty }
        if (filtered.isEmpty()) return 0.0
        return filtered.map { it.score }.average()
    }
}
