package com.udacity.project1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.project1.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.project1.databinding.FragmentInstructionScreenBinding
import com.udacity.project1.databinding.FragmentWelcomeScreenBinding


class InstructionScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding: FragmentInstructionScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction_screen,
            container,
            false)

        val view = binding.root
        binding.buttonInstruction1.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_instructionScreen_to_listshoeScreen)

        }

        return view

    }

}