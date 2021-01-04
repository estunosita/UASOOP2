package com.example.oop2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.oop2.R
import kotlinx.android.synthetic.main.fragment_pilih.view.*

class Pilih : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pilih, container, false)
        view.btn_keluarga.setOnClickListener {
            findNavController().navigate(R.id.action_pilih2_to_listKeluarga)
        }
        view.btn_kelahiran.setOnClickListener {
            findNavController().navigate(R.id.action_pilih2_to_listKelahiran)
        }
        return view
    }

}