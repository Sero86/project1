package com.sero.shoeapp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Viewmodel : ViewModel() {
    private val _listofshoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoesList: LiveData<MutableList<Shoe>>
        get() =_listofshoes

    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun addshoe(add: Shoe) {
        shoesList.value?.add(add)

    }

    fun Shoelistmake() : Shoe {
        return Shoe(name.value ?: "",
            size.value?:"77",
            company.value ?: "77",
            description.value ?: "77",
           )}
    init {
        _listofshoes.value= mutableListOf()
    }
}