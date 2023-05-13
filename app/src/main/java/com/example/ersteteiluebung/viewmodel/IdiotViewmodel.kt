package com.example.ersteteiluebung.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ersteteiluebung.model.IdiotNames

class IdiotViewmodel:ViewModel(){
    val listOfName= MutableLiveData<List<IdiotNames>>()


    fun refresh (){
        getDataFromServer()

    }
   private fun getDataFromServer(){
        val mockdata=listOf<IdiotNames>(
            IdiotNames("shayanxm"),
            IdiotNames("hoo noob"),
            IdiotNames("noob 100 tiri"),
            IdiotNames("ehsan noobe sag"),
            IdiotNames("the karimi")
        )
        listOfName.value=mockdata
    }

}