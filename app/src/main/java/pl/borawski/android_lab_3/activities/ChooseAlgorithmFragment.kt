package pl.borawski.android_lab_3.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import pl.borawski.android_lab_3.R

class ChooseAlgorithmFragment : Fragment(R.layout.choose_algorithm)  {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner: Spinner = view.findViewById(R.id.chooseBox)
        val mainActivity = activity as MainActivity
        val inputField: EditText = view.findViewById(R.id.inputText)
        if (mainActivity.input.isNotEmpty()) inputField.setText(mainActivity.input)
        inputField.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                mainActivity.input = inputField.text.toString()
            }
        })
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.algorithms_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                mainActivity.chosenAlgorithm = spinner.selectedItem.toString()
                println(mainActivity.chosenAlgorithm)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


    }

}