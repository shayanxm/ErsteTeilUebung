package com.example.ersteteiluebung.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ersteteiluebung.R
import com.example.ersteteiluebung.databinding.ActivityMainBinding
import com.example.ersteteiluebung.viewmodel.IdiotViewmodel

lateinit var idiotViewModel:IdiotViewmodel
lateinit var binding:ActivityMainBinding
private val idiotAdapter:IdiotAdapter= IdiotAdapter(arrayListOf())
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding= ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
        setContentView(view)
        idiotViewModel=ViewModelProvider(this).get(IdiotViewmodel::class.java)
        idiotViewModel.refresh()
        binding.recyclerview.apply {
            layoutManager=LinearLayoutManager(context)
            adapter= idiotAdapter
        }
        observeViewmodel()





    }

    private fun observeViewmodel() {
        idiotViewModel.listOfName.observe(this, Observer { IdiotNames ->
            IdiotNames?.let {
                idiotAdapter.updateRec(it)
            }
        })
    }
}