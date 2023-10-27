package com.example.applistacurso.controller

import android.content.Context
import android.content.SharedPreferences
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class DarkModeController(private val context: Context) {
    private val appPreferences: SharedPreferences =
        context.getSharedPreferences("AppListaCursoPreferences", Context.MODE_PRIVATE)

    init {
        val isDarkModeEnabled = isDarkModeEnabled()

        setDarkModeEnabled(isDarkModeEnabled)
        //switch.isChecked = isDarkModeEnabled
    }

    // Função para verificar se o modo escuro está ativado
    fun isDarkModeEnabled(): Boolean {
        return appPreferences.getBoolean("isDarkTheme", false)
    }

    // Função para ativar ou desativar o modo escuro
    fun setDarkModeEnabled(enabled: Boolean) {
        val editor = appPreferences.edit()
        editor.putBoolean("isDarkTheme", enabled)
        editor.apply()

        // Defina o modo escuro baseado na preferência
        if (enabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
