package com.example.applistacurso.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.applistacurso.R
import com.example.applistacurso.controller.CursoController
import com.example.applistacurso.data.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListaCursosActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var cursoController: CursoController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_cursos)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        database = AppDatabase.getInstance(this)
        cursoController = CursoController(database.cursoDAO())

        lifecycleScope.launch(Dispatchers.IO) {
            val cursos = cursoController.getAllCursos()
            println(cursos)
            runOnUiThread {
                val adapter = CursoAdapter(cursos)
                recyclerView.adapter = adapter
            }
        }
    }
}