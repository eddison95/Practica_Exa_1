package com.example.practica_exa_1.data;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practica_exa_1.model.Examen

@Database(entities = [Examen::class], version = 1 , exportSchema = false)
abstract class ExamenDatabase : RoomDatabase(){

    abstract fun examenDao(): ExamenDao

    companion object{
        @Volatile
        private var INSTANCE: ExamenDatabase? = null

        fun getDataBase(context: Context): ExamenDatabase{
            var local = INSTANCE
            if (local != null){
                return local
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExamenDatabase::class.java,
                    "examen_database"
                ).build()
                INSTANCE= instance
                return instance
            }
        }
    }

}
