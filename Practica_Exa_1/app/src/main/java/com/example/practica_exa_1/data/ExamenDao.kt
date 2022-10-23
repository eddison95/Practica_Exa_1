package com.example.practica_exa_1.data;


import com.example.practica_exa_1.model.Examen

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExamenDao {
    //Las funcionaes de bajo nivel para hacer un CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)//que si no lo puede insertar que no de error
    suspend fun addItem(examen: Examen)//esto va a insertar un registro en mi tabla

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upadateItem(examen: Examen)//esto va a actualizar un registro en mi tabla

    @Delete
    suspend fun deleteItem(examen: Examen)//esto va a eliminar un registro en mi tabla

    @Query("SELECT * FROM estado")//Consulta general de SQL
    fun getItems() : LiveData<List<Examen>> //datos que se pueden cargar en tiempo real
}
