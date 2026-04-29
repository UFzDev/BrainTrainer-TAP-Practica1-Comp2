package ufz.dev.braintrainer_tap_practica1_comp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)

        val etGameTime: EditText = findViewById(R.id.etGameTime)
        val btnSave: Button = findViewById(R.id.btnSaveSettings)

        etGameTime.setText(MainActivity.gameTimeSeconds.toString())

        btnSave.setOnClickListener {
            val timeText = etGameTime.text.toString()
            if (timeText.isNotEmpty()) {
                MainActivity.gameTimeSeconds = timeText.toInt()
                Toast.makeText(this, getString(R.string.msg_saved), Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor ingresa un tiempo", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
