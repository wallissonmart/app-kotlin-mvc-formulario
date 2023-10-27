package com.example.applistacurso.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.applistacurso.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        hideStatusBars()

        val splashDelayMillis: Long = 3000 // 3 segundos
        // val mainActivityIntent = Intent(this, MainActivity::class.java)

        // Inicie a atividade principal após o atraso.
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashDelayMillis)

        /*Thread {
            Thread.sleep(splashDelayMillis.toLong())
            startActivity(mainActivityIntent)
            finish()
        }.start()*/
    }

    private fun Activity.hideStatusBars() {
        WindowInsetsControllerCompat(window, window.decorView)
            .hide(WindowInsetsCompat.Type.statusBars())
    }
}

