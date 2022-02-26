package com.example.estudiantes.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.estudiantes.data.EstudianteDatabase
import com.example.estudiantes.model.Estudiante
import com.example.estudiantes.repository.EstudianteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EstudianteViewModel(application: Application)
    : AndroidViewModel(application) {

    val getAllData : LiveData<List<Estudiante>>

            private val repository: EstudianteRepository

            init{
                val estudianteDao = EstudianteDatabase.getDatabase(application).EstudianteDao()
                repository = EstudianteRepository(estudianteDao)
                getAllData = repository.getAllData
            }

        fun addEstudiante(estudiante: Estudiante) {
            viewModelScope.launch(Dispatchers.IO) {repository.addEstudiante(estudiante)}
        }

        fun updateEstudiante(estudiante: Estudiante){
            viewModelScope.launch(Dispatchers.IO) {repository.updateEstudiante(estudiante)}
        }

        fun deleteEstudiante(estudiante: Estudiante){
            viewModelScope.launch(Dispatchers.IO) {repository.deleteEstudiante(estudiante)}
        }

}