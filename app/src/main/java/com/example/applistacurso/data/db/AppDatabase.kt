package com.example.applistacurso.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applistacurso.data.db.dao.CursoDAO
import com.example.applistacurso.data.db.entity.CursoEntity

@Database(entities = [CursoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cursoDAO(): CursoDAO

    companion object {

        private const val DATABASE_NAME: String = "app-lista-curso-db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
                .build()
    }
}
