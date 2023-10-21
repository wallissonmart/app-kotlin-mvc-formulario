package com.example.applistacurso.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.applistacurso.databinding.ActivityMainBinding
import com.example.applistacurso.model.Curso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        val buttonFinalizar = binding.buttonFinalizar
        buttonFinalizar.setOnClickListener {
            handleButtonClick()
        }
    }

    private fun handleButtonClick() {
        val nome = binding.editTextPrimeiroNome.text.toString()
        val sobrenome = binding.editTextSobrenome.text.toString()
        val cursoInteressado = binding.editTextNomeCurso.text.toString()
        val telefone = binding.editTextTelefone.text.toString()

        val curso = Curso(nome, sobrenome, cursoInteressado, telefone)

        Toast.makeText(this, curso.primeiroNome, Toast.LENGTH_LONG).show()
        printCursoDetails(curso)
    }

    private fun printCursoDetails(curso: Curso) {
        println("Detalhes do Curso:")
        println("Nome: ${curso.primeiroNome} ${curso.sobrenome}")
        println("Curso Desejado: ${curso.cursoDesejado}")
        println("Telefone: ${curso.telefone}")
    }
}