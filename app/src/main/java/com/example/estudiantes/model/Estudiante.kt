package com.example.estudiantes.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "estudiante")
data class Estudiante(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "cedula")
    val cedula: String?,
    @ColumnInfo(name = "nombre")
    val nombre: String?,
    @ColumnInfo(name = "edad")
    val edad: String?,
    @ColumnInfo(name = "correo")
    val correo: String?,
    @ColumnInfo(name = "telefono")
    val telefono: String?
) : Parcelable
