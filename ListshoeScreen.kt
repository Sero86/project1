package com.udacity.project1.fragment

import android.os.Bundle
import android.view.Menu
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.project1.R
import com.udacity.project1.databinding.FragmentListshoeScreenBinding
import com.udacity.project1.databinding.InflateviewBinding
import com.udacity.project1.models.Shoe
import com.udacity.project1.models.Viewmodel
import android.view.MenuInflater
import android.widget.LinearLayout
import androidx.core.view.MenuHost
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle


class ListshoeScreen : Fragment(), MenuProvider {

    private val viewmodel:Viewmodel by activityViewModels()
    private lateinit var details: FragmentListshoeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding: FragmentListshoeScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_listshoe_screen,
            container,
            false)
        val view = binding.root
        binding.details = viewmodel
        binding.lifecycleOwner = this
        viewmodel.shoesList.observe(viewLifecycleOwner) { list ->
            for (shoe in list) {

                addto_list(binding.shoeListLinearLayout,shoe,inflater,container)
            }
        }
            binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_listshoeScreen_to_detailsScreen)}

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return view
    }
    private fun addto_list(layout: LinearLayout, shoe:Shoe,
                           inflater: LayoutInflater, container: ViewGroup?){

        val binding = DataBindingUtil.inflate<InflateviewBinding>(
            inflater,R.layout.inflateview, container, false)
        binding.apply {
            shoename.text = shoe.name
            shoecompany.text = shoe.company
            shoeSize.text = shoe.size
            shoeDescription.text = shoe.description
        }

        layout.addView(binding.root)
    }
    override fun onCreateMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
    }
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId){
            R.id.LoginScreen-> findNavController().navigate(R.id.action_listshoeScreen_to_loginScreen)
        }

       return NavigationUI.onNavDestinationSelected(menuItem, requireView().findNavController())
    }


 /*   private fun addShoeToView(
        container: ViewGroup?,
        shoe: Shoe
    ) {

        val shoeBinding: InflateviewBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.inflateview, container, false
        )
        shoeBinding.shoe = shoe
        details.shoeListLinearLayout.addView(shoeBinding.root)

    }
*/

}



