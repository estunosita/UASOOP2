package com.example.oop2.data.kelahiran

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.oop2.data.keluarga.Keluarga

@Dao
interface KelahiranDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addKelahiran(kelahiran: Kelahiran)

    @Query(value = "SELECT * FROM data_kelahiran ORDER BY id ASC")
    fun readAllKelahiran(): LiveData<List<Kelahiran>>

    @Update
    suspend fun updateKElahiran(kelahiran: Kelahiran)

    @Query("DELETE FROM data_kelahiran")
    suspend fun deleteAllKelahiran()

    @Delete
    suspend fun deleteKelahiran(kelahiran: Kelahiran)
}