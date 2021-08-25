package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        openFragment(R.id.place_holder, BlankFragment.newInstance())
        openFragment(R.id.place_holder2, BlankFragment2.newInstance())

        /*
        binding.btnFrag1.setOnClickListener {
            openFragment(R.id.place_holder, BlankFragment.newInstance())
        }

         */

        /*
        binding.btnFrag2.setOnClickListener {
            openFragment(R.id.place_holder, BlankFragment2.newInstance())
        }
        */


    }

    private fun openFragment(id_holder:Int, f:Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(id_holder, f)
            .commit()
    }

}