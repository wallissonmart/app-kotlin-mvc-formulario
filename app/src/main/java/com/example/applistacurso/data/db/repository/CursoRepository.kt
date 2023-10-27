package com.example.applistacurso.data.db.repository

import com.example.applistacurso.model.Curso

interface CursoRepository {

    suspend fun insertCurso(curso: Curso)

    suspend fun getAllCursos(): List<Curso>
}