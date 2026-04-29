package ufz.dev.braintrainer_tap_practica1_comp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)

        val tvAvgTotal: TextView = findViewById(R.id.tvAvgTotal)
        val tvAvgEasy: TextView = findViewById(R.id.tvAvgEasy)
        val tvAvgMedium: TextView = findViewById(R.id.tvAvgMedium)
        val tvAvgHard: TextView = findViewById(R.id.tvAvgHard)
        val rvHistory: RecyclerView = findViewById(R.id.rvHistory)

        // Mostrar estadísticas
        tvAvgTotal.text = String.format(Locale.US, "Promedio General: %.2f", HistoryManager.getAverageTotal())
        tvAvgEasy.text = String.format(Locale.US, "Fácil: %.2f", HistoryManager.getAverageByDifficulty("EASY"))
        tvAvgMedium.text = String.format(Locale.US, "Medio: %.2f", HistoryManager.getAverageByDifficulty("MEDIUM"))
        tvAvgHard.text = String.format(Locale.US, "Difícil: %.2f", HistoryManager.getAverageByDifficulty("HARD"))

        // Configurar RecyclerView
        rvHistory.layoutManager = LinearLayoutManager(this)
        rvHistory.adapter = HistoryAdapter(HistoryManager.records.reversed())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

class HistoryAdapter(private val records: List<GameRecord>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDifficulty: TextView = view.findViewById(R.id.tvItemDifficulty)
        val tvDate: TextView = view.findViewById(R.id.tvItemDate)
        val tvScore: TextView = view.findViewById(R.id.tvItemScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val record = records[position]
        holder.tvDifficulty.text = record.difficulty
        holder.tvScore.text = "Score: ${record.score}"
        
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
        holder.tvDate.text = sdf.format(record.date)
    }

    override fun getItemCount() = records.size
}
