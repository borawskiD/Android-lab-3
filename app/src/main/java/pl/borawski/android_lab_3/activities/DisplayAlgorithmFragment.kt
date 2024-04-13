package pl.borawski.android_lab_3.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import pl.borawski.android_lab_3.R
import pl.borawski.android_lab_3.utilities.AlgorithmsImplementation

class DisplayAlgorithmFragment : Fragment(R.layout.display_algorithm) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity
        if (mainActivity.input.isNotEmpty() && mainActivity.chosenAlgorithm.isNotEmpty()){
            val sorter = AlgorithmsImplementation()
            val chosenOption = mainActivity.chosenAlgorithm
            val beforeText = view.findViewById<TextView>(R.id.before)
            val descriptionText = view.findViewById<TextView>(R.id.description)
            val list = mainActivity.input.split(",").map { it.toInt() }.toMutableList()

            beforeText.text = list.toString()
            var result: MutableList<Int> = mutableListOf()

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

            val afterText: TextView = view.findViewById(R.id.afterText)
            afterText.text = "Po posortowaniu: \n" + result.toString()
            afterText.visibility = View.VISIBLE
        }
    }



}