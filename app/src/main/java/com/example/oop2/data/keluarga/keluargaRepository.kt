package com.example.oop2.data.keluarga

import androidx.lifecycle.LiveData

class keluargaRepository (private val keluargaDao: keluargaDao){

    val readAllkeluarga: LiveData<List<Keluarga>> = keluargaDao.readAllKeluarga()

    suspend fun  addKeluarga (keluarga: Keluarga){
        keluargaDao.addKeluarga(keluarga)
    }
    suspend fun updateKeluarga(keluarga: Keluarga){
        keluargaDao.updateKeluarga(keluarga)
    }
    suspend fun deleteKeluarga(keluarga: Keluarga) {
        keluargaDao.deleteKeluarga(keluarga)
    }
    suspend fun deleteAllKeluarga(){
        keluargaDao.deleteAllKeluarga()
    }
}