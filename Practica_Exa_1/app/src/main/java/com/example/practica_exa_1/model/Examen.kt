package com.example.practica_exa_1.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.*
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "estado")
data class Examen(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "Nombre")
    val nombre: String,
    @ColumnInfo(name = "Capital")
    val capital: String?,
    @ColumnInfo(name = "Poblacion")
    val poblacion: Double?,
    @ColumnInfo(name = "Abreviatura")
    val abreviatura: String?,
    @ColumnInfo(name = "latitud")
    val latitud: Double?,
    @ColumnInfo(name = "longitud")
    val longitud: Double?,
    @ColumnInfo(name = "Medida")
    val medida: Double?
//el ? es para decir que va a hacer nulo, y esta clase es la creacion de la BD
): Parcelable
