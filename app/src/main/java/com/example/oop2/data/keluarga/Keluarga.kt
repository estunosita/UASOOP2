package com.example.oop2.data.keluarga

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey 
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "data_keluarga")
data class Keluarga(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val  nama_kepala: String,
    val  alamat_keluarga: String,
    val  jumlah_anak:Int
): Parcelable