package com.example.oop2.data.keluarga

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KeluargaViewModel(aplication: Application): AndroidViewModel(aplication){
    val readAllKeluarga: LiveData<List<Keluarga>>
    private val repository: keluargaRepository

    init {
        val keluargaDao = keluargaDatabase.getDatabase(aplication).keluargaDao()
        repository = keluargaRepository(keluargaDao)
        readAllKeluarga =repository.readAllkeluarga
    }

    fun addKeluarga(keluarga: Keluarga) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addKeluarga(keluarga)
        }
    }
        fun updateKeluarga(keluarga: Keluarga){
            viewModelScope.launch(Dispatchers.IO){
                repository.updateKeluarga(keluarga)
                repository.updateKeluarga(keluarga)
            }
        }
    fun deleteKeluarga(keluarga: Keluarga){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteKeluarga(keluarga)
        }
    }
    fun deleteAllKeluarga() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllKeluarga()
        }
    }
    }
