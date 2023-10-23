package com.example.applistacurso.view

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.applistacurso.databinding.ActivityMainBinding
import com.example.applistacurso.model.Curso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var appPreferences: SharedPreferences
    private var isDarkThemeEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appPreferences = getSharedPreferences("AppListaCursoPreferences", MODE_PRIVATE)
        isDarkThemeEnabled = appPreferences.getBoolean("isDarkTheme", false)

        getThemeEnabled()
        setupListeners()
        toggleDarkThemeSwitch()
    }

    private fun setupListeners() {
        val buttonFinalizar = binding.buttonFinalizar
        buttonFinalizar.setOnClickListener {
            handleFinalizarClick()
        }
    }

    private fun handleFinalizarClick() {
        val firstName = binding.editTextPrimeiroNome.text.toString()
        val lastName = binding.editTextSobrenome.text.toString()
        val desiredCourse = binding.editTextNomeCurso.text.toString()
        val phone = binding.editTextTelefone.text.toString()

        val curso = Curso(firstName, lastName, desiredCourse, phone)

        Toast.makeText(this, curso.primeiroNome, Toast.LENGTH_LONG).show()
        printCursoDetails(curso)
    }

    private fun getThemeEnabled() {
        val switchMode = binding.switchMode
        switchMode.isActivated = isDarkThemeEnabled

        if (isDarkThemeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun toggleDarkThemeSwitch() {
        val switchMode = binding.switchMode

        switchMode.setOnCheckedChangeListener { _, isChecked ->
            isDarkThemeEnabled = isChecked

            val editor = appPreferences.edit()
            editor.putBoolean("isDarkTheme", isDarkThemeEnabled)
            editor.apply()

            if (isDarkThemeEnabled) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun printCursoDetails(curso: Curso) {
        println("Detalhes do Curso:")
        println("Nome: ${curso.primeiroNome} ${curso.sobrenome}")
        println("Curso Desejado: ${curso.cursoDesejado}")
        println("Telefone: ${curso.telefone}")
    }
}
