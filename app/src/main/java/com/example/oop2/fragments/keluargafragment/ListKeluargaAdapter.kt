package com.example.oop2.fragments.keluargafragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.oop2.R
import com.example.oop2.data.keluarga.Keluarga
import kotlinx.android.synthetic.main.row.view.*

class ListKeluargaAdapter: RecyclerView.Adapter<ListKeluargaAdapter.keluargaViewHolder>() {

    private var keluargaList = emptyList<Keluarga>()

    class keluargaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListKeluargaAdapter.keluargaViewHolder {
        return keluargaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false))
    }

    override fun getItemCount(): Int {
        return keluargaList.size
    }

    override fun onBindViewHolder(holder: keluargaViewHolder, position: Int) {
        val currentItem = keluargaList[position]
        holder.itemView.hasil_id.text = currentItem.id.toString()
        holder.itemView.hasil_nama_kepala.text = currentItem.nama_kepala.toString()
        holder.itemView.hasil_alamat.text = currentItem.alamat_keluarga.toString()
        holder.itemView.hasil_kk.text = currentItem.jumlah_anak.toString()
        holder.itemView.rowKeluarga.setOnClickListener {
            val action = listKeluargaDirections.actionListKeluargaToUpdateKeluarga(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
        }
    fun setDataKeluarga(keluarga: List<Keluarga>){
        this.keluargaList = keluarga
        notifyDataSetChanged()
    }
    }



