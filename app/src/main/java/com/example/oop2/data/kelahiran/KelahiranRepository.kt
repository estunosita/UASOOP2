package com.example.oop2.data.kelahiran

import androidx.lifecycle.LiveData
import com.example.oop2.data.keluarga.Keluarga
import com.example.oop2.data.keluarga.keluargaDao

class KelahiranRepository(private val kelahiranDao: KelahiranDao) {
    val readAllKelahiran: LiveData<List<Kelahiran>> = kelahiranDao.readAllKelahiran()

    suspend fun  addKelahiran (kelahiran: Kelahiran){
        kelahiranDao.addKelahiran(kelahiran)
    }
    suspend fun updateKelahiran(kelahiran: Kelahiran){
        kelahiranDao.updateKElahiran(kelahiran)
    }
    suspend fun deleteKelahiran(kelahiran: Kelahiran) {
        kelahiranDao.deleteKelahiran(kelahiran)
    }
    suspend fun deleteAlKelahiran(){
        kelahiranDao.deleteAllKelahiran()
    }
}