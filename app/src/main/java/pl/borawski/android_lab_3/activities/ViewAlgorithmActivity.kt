package pl.borawski.android_lab_3.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.borawski.android_lab_3.R
import pl.borawski.android_lab_3.utilities.AlgorithmsImplementation

class ViewAlgorithmActivity : AppCompatActivity() {

    private lateinit var values: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_algorithm)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = intent
        values = intent.getStringExtra("values").toString()
        val algorithm = intent.getStringExtra("algorithm")
        sort(values, algorithm!!)

    }

    private fun sort(sequenceText: String, chosenOption: String){

        val list = sequenceText.split(",").map { it.toInt() }.toMutableList()
        val beforeText = findViewById<TextView>(R.id.before)
        val descriptionText = findViewById<TextView>(R.id.description)
        val sorter = AlgorithmsImplementation()
        var result = mutableListOf(1, 2, 3) //default
        beforeText.text = "Przed posortowaniem: \n" + list.toString()
        beforeText.visibility = View.VISIBLE
        when (chosenOption) {
            "Sortowanie przez wybieranie" -> {
                result = sorter.selectionSort(list)
                descriptionText.text = getText(R.string.insert_description)
            }

            "Sortowanie bąbelkowe" -> {
                result = sorter.bubbleSort(list)
                descriptionText.text = getString(R.string.bubble_description)
            }
        }

        var afterText: TextView = findViewById(R.id.afterText)
        afterText.text = "Po posortowaniu: \n" + result.toString()
        afterText.visibility = View.VISIBLE
    }

    fun comeBack(view: View){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("values", values)
        startActivity(intent);
    }
}