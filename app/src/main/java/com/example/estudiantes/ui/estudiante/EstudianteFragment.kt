package com.example.estudiantes.ui.estudiante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.estudiantes.R
import com.example.estudiantes.adapter.EstudianteAdapter
import com.example.estudiantes.databinding.FragmentEstudianteBinding
import com.example.estudiantes.viewmodel.EstudianteViewModel

class EstudianteFragment : Fragment() {

    private lateinit var estudianteViewModel: EstudianteViewModel
    private var _binding: FragmentEstudianteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estudianteViewModel =
            ViewModelProvider(this).get(EstudianteViewModel::class.java)

        _binding = FragmentEstudianteBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_estudiante_to_add_estudiante)
        }

        val estudianteAdapter = EstudianteAdapter()
        val reciclador=binding.reciclador

        reciclador.adapter = estudianteAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        estudianteViewModel.getAllData.observe(viewLifecycleOwner) { estudiantes ->
            estudianteAdapter.setData(estudiantes)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}