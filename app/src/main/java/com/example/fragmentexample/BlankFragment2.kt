package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentexample.databinding.FragmentBlank2Binding
import com.example.fragmentexample.databinding.FragmentBlankBinding


class BlankFragment2 : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank2Binding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSetMsgFrag1.setOnClickListener {
            dataModel.messageToFragment.value = "Hello from Fragment 2"
        }

        binding.btnSetMsgActivity.setOnClickListener {
            dataModel.messageToActivity.value = "Hello from Fragment 2"
        }

        dataModel.messageToFragment2.observe(activity as LifecycleOwner, {
            binding.txtMessage.text = it
        })

    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}