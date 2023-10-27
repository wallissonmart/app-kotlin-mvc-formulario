package com.example.applistacurso.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.applistacurso.controller.CursoController
import com.example.applistacurso.controller.DarkModeController
import com.example.applistacurso.data.db.AppDatabase
import com.example.applistacurso.databinding.ActivityMainBinding
import com.example.applistacurso.model.Curso
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    private lateinit var cursoController: CursoController
    private lateinit var darkModeController: DarkModeController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        darkModeController = DarkModeController(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = AppDatabase.getInstance(this)
        cursoController = CursoController(database.cursoDAO())

        setupListeners()
    }

    private fun setupListeners() {
        binding.switchMode.isChecked = darkModeController.isDarkModeEnabled()

        toggleDarkThemeSwitch()
        handleLimparClick()
        val buttonSalvar = binding.buttonSalvar
        buttonSalvar.setOnClickListener {
            lifecycleScope.launch {
                handleSalvarClick()
            }
        }
        handleFinalizarClick()
    }


    private suspend fun handleSalvarClick() {
        val firstName = binding.editTextPrimeiroNome.text.toString()
        val lastName = binding.editTextSobrenome.text.toString()
        val desiredCourse = binding.editTextNomeCurso.text.toString()
        val phone = binding.editTextTelefone.text.toString()

        val curso = Curso(firstName, lastName, desiredCourse, phone)

        cursoController.insertCurso(curso)
        Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_LONG).show()
        printCursoDetails(curso)

        clearInputFields()
    }

    private fun toggleDarkThemeSwitch() {
        val switchMode = binding.switchMode

        switchMode.setOnCheckedChangeListener { _, isChecked ->
            darkModeController.setDarkModeEnabled(isChecked)
        }
    }

    private fun clearInputFields() {
        binding.editTextPrimeiroNome.text.clear()
        binding.editTextSobrenome.text.clear()
        binding.editTextNomeCurso.text.clear()
        binding.editTextTelefone.text.clear()
    }

    private fun handleLimparClick() {
        val buttonLimpar = binding.buttonLimpar
        buttonLimpar.setOnClickListener {
            clearInputFields()
        }
    }

    private fun handleFinalizarClick() {
        val buttonFinalizar = binding.buttonFinalizar
        buttonFinalizar.setOnClickListener {
            val intent = Intent(this, ListaCursosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun printCursoDetails(curso: Curso) {
        println("Detalhes do Curso:")
        println("Nome: ${curso.primeiroNome} ${curso.sobrenome}")
        println("Curso Desejado: ${curso.cursoDesejado}")
        println("Telefone: ${curso.telefone}")
    }
}