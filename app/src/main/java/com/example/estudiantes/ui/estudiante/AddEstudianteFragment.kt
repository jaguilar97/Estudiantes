package com.example.estudiantes.ui.estudiante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.estudiantes.R
import com.example.estudiantes.databinding.FragmentAddEstudianteBinding
import com.example.estudiantes.model.Estudiante
import com.example.estudiantes.viewmodel.EstudianteViewModel

class AddEstudianteFragment : Fragment(){

    private lateinit var estudianteViewModel: EstudianteViewModel
    private var _binding: FragmentAddEstudianteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estudianteViewModel =
            ViewModelProvider(this).get(EstudianteViewModel::class.java)

        _binding = FragmentAddEstudianteBinding.inflate(inflater, container, false)

        binding.btAdd.setOnClickListener {
            agregarEstudiante()
        }

        return binding.root
    }

    private fun agregarEstudiante() {
        val cedula=binding.txtCedula.text.toString()
        if (cedula.isNotEmpty()) {
            val nombre=binding.txtNombre.text.toString()
            val correo=binding.txtEmail.text.toString()
            val telefono=binding.txtTelefono.text.toString()
            val edad=binding.txtEdad.text.toString()
            val estudiante= Estudiante( 0,cedula, nombre, edad, correo, telefono)
            estudianteViewModel.addEstudiante(estudiante)

            Toast.makeText(requireContext(),
                getString(R.string.msg_add_estudiante),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_add_estudiante_to_nav_estudiante)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}