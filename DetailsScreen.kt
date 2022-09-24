package com.udacity.project1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.project1.R
import com.udacity.project1.databinding.FragmentDetailsScreenBinding
import com.udacity.project1.models.Viewmodel


class DetailsScreen : Fragment() {
    private val viewmodel:Viewmodel by activityViewModels()
    private lateinit var model: Viewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding: FragmentDetailsScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details_screen,
            container,
            false)

        val view = binding.root
        binding.lifecycleOwner = this
        model = ViewModelProvider(this )[Viewmodel::class.java]
        binding.details = model

        binding.buttonDetails2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailsScreen_to_listshoeScreen)
        }

        binding.buttonDetails1.setOnClickListener {
                val shoe = model.Shoelistmake()
            viewmodel.addshoe(shoe)
            Navigation.findNavController(view).navigate(R.id.action_detailsScreen_to_listshoeScreen)

        }

        return view
    }


}