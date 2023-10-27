package com.example.applistacurso.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.applistacurso.data.db.entity.CursoEntity

@Dao
interface CursoDAO {
    @Insert
    suspend fun insert(curso: CursoEntity)

    @Query("SELECT * FROM cursos")
    suspend fun getAll(): List<CursoEntity>
}