package pl.borawski.android_lab_3.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import pl.borawski.android_lab_3.R
import pl.borawski.android_lab_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    var chosenAlgorithm = "" //default value
    var input = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chosenAlgorithm = resources.getStringArray(R.array.algorithms_list)[0]
        replaceFragment(ChooseAlgorithmFragment())


        binding.fragment1btn.setOnClickListener {
            replaceFragment(ChooseAlgorithmFragment())
        }


        binding.fragment2btn.setOnClickListener {
            replaceFragment(DisplayAlgorithmFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment){
        println(input)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }


}