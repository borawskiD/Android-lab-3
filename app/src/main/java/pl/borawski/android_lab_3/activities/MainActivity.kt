package pl.borawski.android_lab_3.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.borawski.android_lab_3.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sortButton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner: Spinner = findViewById(R.id.chooseBox)
        ArrayAdapter.createFromResource(
            this,
            R.array.algorithms_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val intent = intent
        val values: String = intent.getStringExtra("values") ?: ""

        val editText: EditText = findViewById(R.id.inputText)
        editText.setText(values)


    }

    fun changeView(view: View){
        val intent = Intent(this, ViewAlgorithmActivity::class.java)

        val spinner: Spinner = findViewById(R.id.chooseBox)
        val chosenOption = spinner.selectedItem.toString()

        val sequence: EditText = findViewById(R.id.inputText)
        val sequenceText = sequence.text.toString()

        intent.putExtra("values", sequenceText)
        intent.putExtra("algorithm", chosenOption)
        startActivity(intent);

    }
}