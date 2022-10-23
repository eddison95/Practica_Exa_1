package com.example.practica_exa_1.repository;

import androidx.lifecycle.LiveData
import com.example.practica_exa_1.data.ExamenDao;
import com.example.practica_exa_1.model.Examen;


class ExamenRepository (private val examenDao:ExamenDao) {
    suspend fun saveItem(examen:Examen){
        if (examen.id==0){
            examenDao.addItem(examen)//Si es un lugar nuevo se añade aca
        }else{
            examenDao.upadateItem(examen)// si ya el lugar se sabe el id se actualiza aca
        }
    }
    suspend fun deleteItems(examen:Examen){
        if (examen.id!=0){//Si el id tiene un valor lo va a intentar eliminar
            examenDao.deleteItem(examen)
        }
    }

    val getItems: LiveData<List<Examen>> = examenDao.getItems()
}
