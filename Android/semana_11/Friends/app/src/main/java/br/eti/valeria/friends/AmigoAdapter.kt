package br.eti.valeria.friends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class AmigoAdapter(val lista: ArrayList<Amigo>): RecyclerView.Adapter<AmigoAdapter.AmigoHolder>() {
    var listener: OnItemClickRecyclerView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmigoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return AmigoHolder(view)
    }

    override fun onBindViewHolder(holder: AmigoHolder, position: Int) {
        val amigo = this.lista.get(position)
        holder.tvNome.text = amigo.nome
        holder.tvEmail.text = amigo.email
    }

    fun add(amigo: Amigo){
        this.lista.add(amigo)
        notifyItemInserted(this.lista.size)
    }

    fun mov(from: Int, to: Int){
        Collections.swap(this.lista, from, to)
        notifyItemMoved(from, to)
    }

    fun del(position: Int){
        this.lista.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, this.lista.size)
    }

    override fun getItemCount(): Int = this.lista.size

    inner class AmigoHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvNome: TextView
        var tvEmail: TextView

        init {
            this.tvNome = itemView.findViewById(R.id.tvItemNome)
            this.tvEmail = itemView.findViewById(R.id.tvItemEmail)

//            Método tradicional
//            itemView.setOnClickListener{
//                val amigo = this@AmigoAdapter.lista[adapterPosition]
//                Toast.makeText(itemView.context, amigo.nome, Toast.LENGTH_SHORT).show()
//                notifyItemChanged(adapterPosition)
//            }

//            Método alternativo
            itemView.setOnClickListener{
                this@AmigoAdapter.listener?.OnClick(adapterPosition)
            }
        }
    }
}