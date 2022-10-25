package com.example.practica_exa_1.ui.exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_exa_1.R
import com.example.practica_exa_1.adapter.ExamAdapter
import com.example.practica_exa_1.databinding.FragmentExamBinding
import com.example.practica_exa_1.viewmodel.ExamViewModel

class ExamenFragment : Fragment() {

    private var _binding: FragmentExamBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val examViewModel =
            ViewModelProvider(this).get(ExamViewModel::class.java)

        _binding = FragmentExamBinding.inflate(inflater, container, false)
        binding.addExamenFabButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_exam_to_addExamenFragment)
        }
        //se genera el recycler view para ver la informacion
        val ExamenAddapter= ExamAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter= ExamenAddapter
        reciclador.layoutManager= LinearLayoutManager(requireContext())

        examViewModel.getExamenes.observe(viewLifecycleOwner){
                it -> ExamenAddapter.setLista(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}