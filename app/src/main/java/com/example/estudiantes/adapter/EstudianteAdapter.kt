package com.example.estudiantes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.estudiantes.databinding.EstudianteFilaBinding
import com.example.estudiantes.model.Estudiante
import com.example.estudiantes.ui.estudiante.EstudianteFragmentDirections

class EstudianteAdapter : RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder>() {


    private var listaEstudiantes = emptyList<Estudiante>()

    inner class EstudianteViewHolder(private val itemBinding: EstudianteFilaBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(estudiante : Estudiante){
            itemBinding.tvNombre.text = estudiante.nombre
            itemBinding.tvCedula.text = estudiante.cedula
            itemBinding.tvEdad.text = estudiante.edad
            itemBinding.tvTelefono.text = estudiante.telefono
            itemBinding.tvCorreo.text = estudiante.correo
            itemBinding.vistaFila.setOnClickListener{
                val  accion = EstudianteFragmentDirections.actionNavEstudianteToNavUpdateEstudiante()
                itemView.findNavController().navigate(accion)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstudianteViewHolder {
        val itemBinding = EstudianteFilaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false) //iflate toma toda la info y construye la tarjeta a nivel de XML
        return EstudianteViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: EstudianteViewHolder, position: Int) {
        val estudiante = listaEstudiantes[position]
        holder.bind(estudiante)
    }

    override fun getItemCount(): Int {
        return listaEstudiantes.size
    }

    fun setData(estudiantes : List<Estudiante>){
        this.listaEstudiantes = estudiantes
        notifyDataSetChanged()
    }

}