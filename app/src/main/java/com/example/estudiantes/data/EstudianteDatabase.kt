package com.example.estudiantes.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.estudiantes.model.Estudiante

@Database(entities = [Estudiante::class], version = 1, exportSchema = false)
abstract class EstudianteDatabase : RoomDatabase() {

    abstract fun EstudianteDao() : EstudianteDao

    companion object{

    @Volatile
    private var INSTANCE: EstudianteDatabase? = null

    fun getDatabase(context: android.content.Context) : EstudianteDatabase {

            var instance = INSTANCE
            if (instance != null){
                return instance
            }
            synchronized(this){
                val basedatos = Room.databaseBuilder(
                    context.applicationContext,
                    EstudianteDatabase::class.java,
                    "Estudiante_database"
                ).build()
                INSTANCE = basedatos
                return basedatos
            }
        }
    }
}