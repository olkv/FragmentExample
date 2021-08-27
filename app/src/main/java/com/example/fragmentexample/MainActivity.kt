package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.fragmentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        openFragment(R.id.place_holder, BlankFragment.newInstance())
        openFragment(R.id.place_holder2, BlankFragment2.newInstance())

        dataModel.messageToActivity.observe(this, {
            binding.textView.text = it
        })

    }

    private fun openFragment(id_holder:Int, f:Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(id_holder, f)
            .commit()
    }

}