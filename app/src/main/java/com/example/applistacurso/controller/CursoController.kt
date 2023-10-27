package com.example.applistacurso.controller

import com.example.applistacurso.data.db.dao.CursoDAO
import com.example.applistacurso.data.db.entity.CursoEntity
import com.example.applistacurso.data.db.repository.CursoRepository
import com.example.applistacurso.model.Curso

class CursoController(private val cursoDao: CursoDAO) : CursoRepository {

    override suspend fun insertCurso(curso: Curso) {
        // Converter Curso para CursoEntity
        val cursoEntity = CursoEntity(
            primeiroNome = curso.primeiroNome,
            sobrenome = curso.sobrenome,
            cursoDesejado = curso.cursoDesejado,
            telefone = curso.telefone
        )

        try {
            cursoDao.insert(cursoEntity)
            println("Curso inserido com sucesso: $cursoEntity")
        } catch (e: Exception) {
            println("Erro ao inserir curso: ${e.message}")
        }
    }

    override suspend fun getAllCursos(): List<Curso> {
        val cursoEntities = cursoDao.getAll()
        println(cursoEntities)
        // Converter CursoEntity para Curso
        return cursoEntities.map { cursoEntity ->
            Curso(
                primeiroNome = cursoEntity.primeiroNome,
                sobrenome = cursoEntity.sobrenome,
                cursoDesejado = cursoEntity.cursoDesejado,
                telefone = cursoEntity.telefone
            )
        }
    }
}