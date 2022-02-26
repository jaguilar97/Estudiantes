package com.example.estudiantes.repository

import androidx.lifecycle.LiveData
import com.example.estudiantes.data.EstudianteDao
import com.example.estudiantes.model.Estudiante

class EstudianteRepository (private val estudianteDao: EstudianteDao) {

    val getAllData : LiveData<List<Estudiante>> = estudianteDao.getAllData()

    suspend fun addEstudiante(estudiante: Estudiante){
        estudianteDao.addEstudiante(estudiante)
    }

    suspend fun updateEstudiante(estudiante: Estudiante){
        estudianteDao.updateEstudiante(estudiante)
    }

    suspend fun deleteEstudiante(estudiante: Estudiante){
        estudianteDao.deleteEstudiante(estudiante)
    }

}