package ufz.dev.braintrainer_tap_practica1_comp2

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var tvPreparationCount: TextView
    private lateinit var layoutPreparation: LinearLayout
    private lateinit var layoutGameContent: RelativeLayout
    
    private lateinit var tvTimer: TextView
    private lateinit var tvScore: TextView
    private lateinit var tvOperation: TextView
    private lateinit var btnOptions: List<Button>

    private var score = 0
    private var correctAnswer = 0
    private var difficulty = "EASY"
    private var gameTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        difficulty = intent.getStringExtra("DIFFICULTY") ?: "EASY"

        // Referencias
        tvPreparationCount = findViewById(R.id.tvPreparationCount)
        layoutPreparation = findViewById(R.id.layoutPreparation)
        layoutGameContent = findViewById(R.id.layoutGameContent)
        
        tvTimer = findViewById(R.id.tvTimer)
        tvScore = findViewById(R.id.tvScore)
        tvOperation = findViewById(R.id.tvOperation)
        
        btnOptions = listOf(
            findViewById(R.id.btnOption1),
            findViewById(R.id.btnOption2),
            findViewById(R.id.btnOption3),
            findViewById(R.id.btnOption4)
        )

        // Configurar botones
        btnOptions.forEach { button ->
            button.setOnClickListener {
                checkAnswer(button.text.toString().toInt())
            }
        }

        startPreparationCountDown()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun startPreparationCountDown() {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = (millisUntilFinished / 1000) + 1
                tvPreparationCount.text = secondsRemaining.toString()
            }

            override fun onFinish() {
                showGameContent()
            }
        }.start()
    }

    private fun showGameContent() {
        layoutPreparation.visibility = View.GONE
        layoutGameContent.visibility = View.VISIBLE
        generateQuestion()
        startGameTimer()
    }

    private fun startGameTimer() {
        val totalMillis = MainActivity.gameTimeSeconds * 1000L
        gameTimer = object : CountDownTimer(totalMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                tvTimer.text = String.format(Locale.US, "%02d:%02d", seconds / 60, seconds % 60)
            }

            override fun onFinish() {
                tvTimer.text = getString(R.string.timer_zero)
                endGame()
            }
        }.start()
    }

    private fun generateQuestion() {
        val range = when (difficulty) {
            "EASY" -> 0..10
            "MEDIUM" -> 0..20
            "HARD" -> 1..50
            else -> 0..10
        }

        val operators = when (difficulty) {
            "EASY" -> listOf("+", "-")
            "MEDIUM" -> listOf("+", "-", "*")
            "HARD" -> listOf("+", "-", "*", "/")
            else -> listOf("+", "-")
        }

        val op = operators.random()
        var a = range.random()
        var b = range.random()

        when (op) {
            "+" -> {
                correctAnswer = a + b
                tvOperation.text = getString(R.string.op_format_sum, a, b)
            }
            "-" -> {
                if (a < b) { val temp = a; a = b; b = temp }
                correctAnswer = a - b
                tvOperation.text = getString(R.string.op_format_sub, a, b)
            }
            "*" -> {
                correctAnswer = a * b
                tvOperation.text = getString(R.string.op_format_mul, a, b)
            }
            "/" -> {
                val res = range.random()
                b = if (b == 0) 1 else b
                a = res * b
                correctAnswer = res
                tvOperation.text = getString(R.string.op_format_div, a, b)
            }
        }

        setupButtons()
    }

    private fun setupButtons() {
        val answers = mutableListOf<Int>()
        answers.add(correctAnswer)

        while (answers.size < 4) {
            val distractor = correctAnswer + Random.nextInt(-10, 11)
            if (distractor !in answers && distractor >= 0) {
                answers.add(distractor)
            }
        }

        answers.shuffle()
        for (i in 0 until 4) {
            btnOptions[i].text = answers[i].toString()
        }
    }

    private fun checkAnswer(selected: Int) {
        if (selected == correctAnswer) {
            score++
            tvScore.text = getString(R.string.score_format, score)
            generateQuestion()
        } else {
            generateQuestion()
        }
    }

    private fun endGame() {
        btnOptions.forEach { it.isEnabled = false }
        HistoryManager.addRecord(score, difficulty)
        Toast.makeText(this, "Juego terminado. Score final: $score", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        gameTimer?.cancel()
    }
}
