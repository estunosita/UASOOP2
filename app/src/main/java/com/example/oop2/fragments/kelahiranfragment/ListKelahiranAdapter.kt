package com.example.oop2.fragments.kelahiranfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.oop2.R
import com.example.oop2.data.kelahiran.Kelahiran
import kotlinx.android.synthetic.main.custom_row.view.*

class ListKelahiranAdapter: RecyclerView.Adapter<ListKelahiranAdapter.KelahiranViewHolder>() {

    private var kelahiranList = emptyList<Kelahiran>()

    class KelahiranViewHolder(itemView1: View): RecyclerView.ViewHolder(itemView1){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelahiranViewHolder {
        return KelahiranViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun getItemCount(): Int {
        return kelahiranList.size
    }

    override fun onBindViewHolder(holder: KelahiranViewHolder, position: Int) {
        val currentItem = kelahiranList[position]
        holder.itemView.id_kelahiran.text = currentItem.id.toString()
        holder.itemView.txt_nama.text = currentItem.nama_kelahiran
        holder.itemView.txt_berat.text = currentItem.berat.toString()
        holder.itemView.txt_panjang.text = currentItem.panjang.toString()

        holder.itemView.rowKelahiran.setOnClickListener {
            val action = ListKelahiranDirections.actionListKelahiranToUpdateKelahiran(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(kelahiran: List<Kelahiran>){
        this.kelahiranList = kelahiran
        notifyDataSetChanged()
    }
}