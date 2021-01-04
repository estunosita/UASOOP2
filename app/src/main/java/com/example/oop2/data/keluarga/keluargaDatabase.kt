package com.example.oop2.data.keluarga

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Keluarga::class], version = 1, exportSchema = false)

abstract  class  keluargaDatabase: RoomDatabase(){

    abstract  fun keluargaDao(): keluargaDao

    companion object{
        @Volatile
        private var  INSTANCE: keluargaDatabase? = null

        fun getDatabase(context: Context): keluargaDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    keluargaDatabase::class.java,
                    "keluarga_database")

                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}