package com.example.podexapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.source.PocketNetworkDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val dataSource: PocketNetworkDataSource) : ViewModel() {

    fun getPodexList() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = dataSource.getPokemonList(10,10)
            Log.d("PodexApp", "VM > list: $list")
        }
    }

}