package com.udacity.project1.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.project1.R
import com.udacity.project1.databinding.FragmentLoginScreenBinding


class LoginScreen : Fragment() {





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{

        val binding: FragmentLoginScreenBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login_screen,
            container,
            false)
        val view = binding.root
        binding.buttonLogin1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginScreen_to_welcomeScreen)
        }
        binding.buttonLogin2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginScreen_to_welcomeScreen)
        }

        return view
    }


}