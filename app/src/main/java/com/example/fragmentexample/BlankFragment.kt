package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentexample.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater)

        return binding.root
        //return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSetMsgFrag2.setOnClickListener {
            dataModel.messageToFragment2.value = "Hello From Fragment 1"
        }

        binding.btnSetMsgToActivity.setOnClickListener {
            dataModel.messageToActivity.value = "Hello From Fragment 1"
        }

        dataModel.messageToFragment.observe(activity as LifecycleOwner, {
            binding.txtMessage.text = it
        })

    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}