package com.example.practica_exa_1.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_exa_1.databinding.ExamenFilaBinding
import com.example.practica_exa_1.model.Examen
import com.example.practica_exa_1.ui.exam.ExamenFragmentDirections



class ExamAdapter : RecyclerView.Adapter<ExamAdapter.ExamenViewHolder>(){

    // esto lo que hace es que carga la informacion de los datos en la vista, cada cuadrito de informacion que exista esto lo genera
    inner class ExamenViewHolder(private val itemBinding: ExamenFilaBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
        fun dibuja(examen: Examen){
            itemBinding.tvNombre.text = examen.nombre
            itemBinding.tvCapital.text = examen.capital
            itemBinding.tvAdberviatura.text = examen.abreviatura
            itemBinding.examenVista.setOnClickListener {
                val action = ExamenFragmentDirections.actionNavExamToUpdateExamenFragment(examen)
                itemView.findNavController().navigate(action)
            }

        }
    }
    // esta lista es donde estan los objertos lugar a dibujarse
    private var listaExamen = emptyList<Examen>()

    // esta funcion crea cajitas para cada lugar o cada item en memoria (vista)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamenViewHolder {
        val itemBinding = ExamenFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExamenViewHolder(itemBinding)
    }
    //esta funcion toma un lugar y lo envia a pantalla o a dibujar
    override fun onBindViewHolder(holder: ExamenViewHolder, position: Int) {
        val lugar = listaExamen[position]
        holder.dibuja(lugar)
    }
    // esta funcion devuelve la cantidad de elementos a dibijar, cajitas o items o registros
    override fun getItemCount(): Int {
        return listaExamen.size
    }

    fun setLista(examenes: List<Examen>){
        this.listaExamen = examenes
        notifyDataSetChanged()
    }


}