package com.example.oop2.fragments.keluargafragment

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.oop2.R
import com.example.oop2.data.keluarga.Keluarga
import com.example.oop2.data.keluarga.KeluargaViewModel
import kotlinx.android.synthetic.main.fragment_add_keluarga.*
import kotlinx.android.synthetic.main.fragment_add_keluarga.view.*

class addKeluarga : Fragment() {
    private lateinit var mkeluargaViewModel: KeluargaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_keluarga, container, false)
        mkeluargaViewModel = ViewModelProvider(this).get(KeluargaViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertToDatabase()
    }
        return view
}
    private fun insertToDatabase(){
        val nama_kepala = add_keluarga.text.toString()
        val alamat = add_alamat.text.toString()
        val no_kk = add_no_nik.text

        if(inputCheck(nama_kepala,alamat,no_kk)){
            val keluarga = Keluarga(0, nama_kepala,alamat,Integer.parseInt(no_kk.toString()))
            mkeluargaViewModel.addKeluarga(keluarga)
            Toast.makeText(requireContext(), "Berhasil Menambahkan Data!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addKeluarga_to_listKeluarga)
        }else{
            Toast.makeText(requireContext(), "Gagal Menambahkan Data!", Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputCheck(nama_kepala:String, alamat:String, no_kk: Editable):Boolean{
        return !(TextUtils.isEmpty(nama_kepala) && TextUtils.isEmpty(alamat) && no_kk.isEmpty())

    }


}