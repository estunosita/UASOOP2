package com.example.oop2.fragments.kelahiranfragment

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
import com.example.oop2.data.kelahiran.Kelahiran
import com.example.oop2.data.kelahiran.KelahiranViewModel
import com.example.oop2.data.keluarga.Keluarga
import com.example.oop2.data.keluarga.KeluargaViewModel
import kotlinx.android.synthetic.main.fragment_add_kelahiran.*
import kotlinx.android.synthetic.main.fragment_add_kelahiran.view.*
import kotlinx.android.synthetic.main.fragment_add_keluarga.*
import kotlinx.android.synthetic.main.fragment_add_keluarga.view.*

class AddKelahiran : Fragment() {
    private lateinit var mKelahiranViewModel: KelahiranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_kelahiran, container, false)
        mKelahiranViewModel = ViewModelProvider(this).get(KelahiranViewModel::class.java)

        view.add_btn_kelahiran.setOnClickListener {
            insertToDatabase()
        }
        return view
    }
    private fun insertToDatabase(){
        val nama_kelahiran = add_kelahiran.text.toString()
        val berat = add_berat.text
        val panjang = add_panjang.text

        if(inputCheck(nama_kelahiran,berat,panjang)){
            val kelahiran = Kelahiran(0, nama_kelahiran,Integer.parseInt(berat.toString()),Integer.parseInt(panjang.toString()))
            mKelahiranViewModel.addKelahiran(kelahiran)
            Toast.makeText(requireContext(), "Berhasil Menambahkan Data!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addKelahiran_to_listKelahiran)
        }else{
            Toast.makeText(requireContext(), "Gagal Menambahkan Data!", Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputCheck(nama_kelahiran:String, berat: Editable, panjang: Editable):Boolean{
        return !(TextUtils.isEmpty(nama_kelahiran) && berat.isEmpty() && panjang.isEmpty())

    }

}