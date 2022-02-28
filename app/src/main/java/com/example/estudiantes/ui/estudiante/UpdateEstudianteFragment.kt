package com.example.estudiantes.ui.estudiante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.estudiantes.R
import com.example.estudiantes.databinding.FragmentUpdateEstudianteBinding
import com.example.estudiantes.model.Estudiante
import com.example.estudiantes.viewmodel.EstudianteViewModel

class UpdateEstudianteFragment : Fragment(){

    private lateinit var estudianteViewModel: EstudianteViewModel
    private var _binding: FragmentUpdateEstudianteBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<UpdateEstudianteFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estudianteViewModel = ViewModelProvider(this).get(EstudianteViewModel::class.java)

        _binding = FragmentUpdateEstudianteBinding.inflate(inflater, container, false)

        binding.txtNombre.setText(args.estudiante.nombre)
        binding.txtCedula.setText(args.estudiante.cedula)
        binding.txtEdad.setText(args.estudiante.edad)
        binding.txtTelefono.setText(args.estudiante.telefono)
        binding.txtEmail.setText(args.estudiante.correo)

        binding.btUpdate.setOnClickListener { actualizarEstudiante() }


        return binding.root
    }

    private fun actualizarEstudiante() {
        val nombre=binding.txtNombre.text.toString()
        if (nombre.isNotEmpty()) {
            val cedula=binding.txtCedula.text.toString()
            val edad=binding.txtEdad.text.toString()
            val telefono=binding.txtTelefono.text.toString()
            val correo=binding.txtEmail.text.toString()
            val estudiante=Estudiante(args.estudiante.id, nombre, cedula, edad, telefono, correo)
            estudianteViewModel.updateEstudiante(estudiante)
            Toast.makeText(requireContext(),
                getString(R.string.msg_update),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_nav_update_estudiante_to_nav_estudiante)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}