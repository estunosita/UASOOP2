package com.example.oop2.data.kelahiran

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "data_kelahiran")
data class Kelahiran(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val  nama_kelahiran: String,
    val  panjang: Int,
    val  berat: Int
): Parcelable