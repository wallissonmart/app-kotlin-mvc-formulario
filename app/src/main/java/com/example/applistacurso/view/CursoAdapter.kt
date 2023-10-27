package com.example.applistacurso.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applistacurso.R
import com.example.applistacurso.model.Curso

class CursoAdapter(private val cursos: List<Curso>) :
    RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista_cursos, parent, false)
        return CursoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        holder.bind(cursos[position])
    }

    override fun getItemCount(): Int {
        return cursos.size
    }

    inner class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val primeiroNomeTextView: TextView = itemView.findViewById(R.id.textPrimeiroNome)
        private val sobrenomeTextView: TextView = itemView.findViewById(R.id.textSobrenome)
        private val cursoDesejadoTextView: TextView = itemView.findViewById(R.id.textCursoDesejado)
        private val telefoneTextView: TextView = itemView.findViewById(R.id.textTelefone)


        fun bind(curso: Curso) {
            primeiroNomeTextView.text = curso.primeiroNome
            sobrenomeTextView.text = curso.sobrenome
            cursoDesejadoTextView.text = curso.cursoDesejado
            telefoneTextView.text = curso.telefone
        }
    }
}
