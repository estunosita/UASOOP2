package com.example.oop2.data.kelahiran

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KelahiranViewModel(aplication: Application): AndroidViewModel(aplication) {
    var readAllkelahiran: LiveData<List<Kelahiran>>
    private val repository: KelahiranRepository

    init {
        val kelahiranDao = KelahiranDatabase.getDatabase2(aplication).kelahiranDao()
        repository = KelahiranRepository(kelahiranDao)
        readAllkelahiran =repository.readAllKelahiran
    }
    fun addKelahiran(kelahiran: Kelahiran) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addKelahiran(kelahiran)
        }
    }
    fun updateKelahiran(kelahiran: Kelahiran){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateKelahiran(kelahiran)
        }
    }
    fun deleteKelahiran(kelahiran: Kelahiran){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteKelahiran(kelahiran)
        }
    }
    fun deleteAllKelahiran() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAlKelahiran()
        }
    }
}