package com.example.oop2.data.keluarga

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface keluargaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addKeluarga(keluarga: Keluarga)

    @Query(value = "SELECT * FROM data_keluarga ORDER BY id ASC")
    fun readAllKeluarga(): LiveData<List<Keluarga>>

    @Update
    suspend fun updateKeluarga(keluarga: Keluarga)

    @Query("DELETE FROM data_keluarga")
    suspend fun deleteAllKeluarga()

    @Delete
    suspend fun deleteKeluarga(keluarga: Keluarga)

}