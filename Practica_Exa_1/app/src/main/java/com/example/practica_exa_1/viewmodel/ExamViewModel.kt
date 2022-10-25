package com.example.practica_exa_1.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.practica_exa_1.data.ExamenDatabase
import com.example.practica_exa_1.model.Examen
import com.example.practica_exa_1.repository.ExamenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExamViewModel (application: Application) : AndroidViewModel(application) {
    private val examenRepository: ExamenRepository
    val getExamenes: LiveData<List<Examen>>

    init {
        val examenDao= ExamenDatabase.getDataBase(application).examenDao()
        examenRepository= ExamenRepository(examenDao)
        getExamenes= examenRepository.getItems
    }

    fun saveLugar(lugar: Examen) {
        viewModelScope.launch(Dispatchers.IO) {
            examenRepository.saveItem(lugar)
        }
    }
    fun deleteLugar(lugar:Examen){
        viewModelScope.launch(Dispatchers.IO){
            examenRepository.deleteItems(lugar)
        }
    }

}