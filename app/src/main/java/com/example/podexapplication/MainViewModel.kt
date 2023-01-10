package com.example.podexapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.PodexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val repository: PodexRepository) : ViewModel() {

    fun getPodexList() {
        viewModelScope.launch {
            repository.getPokemonList(10,10)
                .collect {
                    coroutineVMLog("VM > list: $it")
                }
            //val list = dataSource.getPokemonList(10,10)

        }
    }


    private fun CoroutineScope.coroutineVMLog(message: String) {
        Log.d("PodexAppVM", "start request > ThreadInfo: ${Thread.currentThread().name} > CoroutineInfo: ${this.coroutineContext}")
        Log.d("PodexAppVM", "data: $message")
    }
}