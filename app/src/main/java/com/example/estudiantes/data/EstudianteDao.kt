package com.example.estudiantes.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.estudiantes.model.Estudiante

@Dao
interface EstudianteDao {

    @Query( "select * from ESTUDIANTE")
    fun getAllData() : LiveData<List<Estudiante>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEstudiante(estudiante: Estudiante)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateEstudiante(estudiante: Estudiante)

    @Delete
    suspend fun deleteEstudiante(estudiante: Estudiante)

}