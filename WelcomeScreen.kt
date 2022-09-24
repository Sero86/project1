package com.udacity.project1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.project1.R
import com.udacity.project1.databinding.FragmentWelcomeScreenBinding



class WelcomeScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentWelcomeScreenBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome_screen,
            container,
            false)
        val view = binding.root
            binding.buttonWelcom1.setOnClickListener{
                Navigation.findNavController(view).navigate(R.id.action_welcomeScreen_to_instructionScreen)

                 }

        return view
    }


}