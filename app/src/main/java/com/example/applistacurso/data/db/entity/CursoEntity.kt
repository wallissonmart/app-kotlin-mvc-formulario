package com.example.applistacurso.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cursos")
data class CursoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val primeiroNome: String,
    val sobrenome: String,
    val cursoDesejado: String,
    val telefone: String
)