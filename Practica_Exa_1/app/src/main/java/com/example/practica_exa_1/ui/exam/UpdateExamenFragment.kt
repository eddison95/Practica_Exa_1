package com.example.practica_exa_1.ui.exam

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practica_exa_1.R
import com.example.practica_exa_1.databinding.FragmentUpdateExamenBinding
import com.example.practica_exa_1.databinding.FragmentExamBinding
import com.example.practica_exa_1.model.Examen
import com.example.practica_exa_1.viewmodel.ExamViewModel

class UpdateExamenFragment : Fragment() {

    private val args by navArgs<UpdateExamenFragmentArgs>()

    private lateinit var lugarViewModel : ExamViewModel
    private var _binding: FragmentUpdateExamenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel =
            ViewModelProvider(this).get(ExamViewModel::class.java)

        _binding = FragmentUpdateExamenBinding.inflate(inflater, container, false)

        binding.etNombre.setText(args.examen.nombre)
        binding.etCapital.setText(args.examen.capital)
        binding.etAbreviatura.setText(args.examen. abreviatura)





        binding.btUpdate.setOnClickListener{ Actualizar()}
        binding.btDelete.setOnClickListener{deleteLugar()}

        return binding.root
    }

    private fun deleteLugar() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setTitle(R.string.bt_delete)
        alerta.setMessage(getString(R.string.msg_deleted)+"${args.examen.nombre}")
        alerta.setPositiveButton(getString(R.string.msg_si_deleted)){_,_ ->
            lugarViewModel.deleteLugar(args.examen)
            Toast.makeText(requireContext(),getString(R.string.msg_deleted),Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateExamenFragment_to_nav_exam)
        }
        alerta.setNegativeButton(getString(R.string.msg_no_deleted)){_,_ ->}
            alerta.create().show()

    }

    private fun Actualizar() {
        val nombre = binding.etNombre.text.toString() // optiene el dato digitado en el formulario
        if (nombre.isNotEmpty()) {

            val capital = binding.etCapital.text.toString() // optiene el dato digitado en el formulario
            val abreviatura = binding.etAbreviatura.text.toString() // optiene el dato digitado en el formulario

            val examen = Examen(args.examen.id, nombre, capital, args.examen.poblacion , abreviatura, args.examen.latitud, args.examen.longitud,args.examen.medida)

            //Se procede a guardar y registrar el lugar
            lugarViewModel.saveLugar(examen)

            Toast.makeText(requireContext(), getString(R.string.msg_updated), Toast.LENGTH_SHORT)
                .show()

            findNavController().navigate(R.id.action_updateExamenFragment_to_nav_exam)
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