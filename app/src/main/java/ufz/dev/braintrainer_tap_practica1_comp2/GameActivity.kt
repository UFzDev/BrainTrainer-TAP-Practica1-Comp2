package ufz.dev.braintrainer_tap_practica1_comp2

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {

    private lateinit var tvPreparationCount: TextView
    private lateinit var layoutPreparation: LinearLayout
    private lateinit var layoutGameContent: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        tvPreparationCount = findViewById(R.id.tvPreparationCount)
        layoutPreparation = findViewById(R.id.layoutPreparation)
        layoutGameContent = findViewById(R.id.layoutGameContent)

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
    }
}
