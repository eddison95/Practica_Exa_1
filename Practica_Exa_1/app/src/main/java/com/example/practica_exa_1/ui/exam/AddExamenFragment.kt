package com.example.practica_exa_1.ui.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practica_exa_1.R
import com.example.practica_exa_1.databinding.FragmentAddExamenBinding
import com.example.practica_exa_1.databinding.FragmentExamBinding
import com.example.practica_exa_1.model.Examen
import com.example.practica_exa_1.viewmodel.ExamViewModel

class AddExamenFragment : Fragment() {

    private lateinit var examenViewModel : ExamViewModel
    private var _binding: FragmentAddExamenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        examenViewModel =
            ViewModelProvider(this).get(ExamViewModel::class.java)

        _binding = FragmentAddExamenBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener{ Agregar()}


        return binding.root
    }

    private fun Agregar() {
        val nombre = binding.etNombre.text.toString() // optiene el dato digitado en el formulario
        if (nombre.isNotEmpty()) {

            val capital = binding.etCapital.text.toString() // optiene el dato digitado en el formulari
            val abreviatura = binding.etAbreviatura.text.toString() // optiene el dato digitado en el formulario

            val examen = Examen(0, nombre, capital, 0.0, abreviatura, 0.0, 0.0, 0.0)

            //Se procede a guardar y registrar el lugar
            examenViewModel.saveLugar(examen)

            Toast.makeText(requireContext(), getString(R.string.msg_added), Toast.LENGTH_SHORT)
                .show()

            findNavController().navigate(R.id.action_addExamenFragment_to_nav_exam)
        } else {
            //No se puede registrar el lugar por que falta info
            Toast.makeText(
                requireContext(),
                getString(R.string.msg_data),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}