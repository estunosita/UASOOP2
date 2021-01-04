package com.example.oop2.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.oop2.R
import com.example.oop2.data.keluarga.Keluarga
import com.example.oop2.data.keluarga.KeluargaViewModel
import kotlinx.android.synthetic.main.fragment_add_keluarga.*
import kotlinx.android.synthetic.main.fragment_update_keluarga.*
import kotlinx.android.synthetic.main.fragment_update_keluarga.view.*

class updateKeluarga : Fragment() {
    private val args by navArgs<updateKeluargaArgs>()
    private lateinit var mkeluargaViewModel: KeluargaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_keluarga, container, false)
        mkeluargaViewModel = ViewModelProvider(this).get(KeluargaViewModel::class.java)

        view.update_keluarga.setText(args.currentFamily.nama_kepala)
        view.update_alamat.setText(args.currentFamily.alamat_keluarga)
        view.update_no_nik.setText(args.currentFamily.jumlah_anak.toString())

        view.updt_btn.setOnClickListener {
            updateKeluarga()
        }
        setHasOptionsMenu(true)
        return view
    }

    private fun updateKeluarga() {
        val nama_kepala = update_keluarga.text.toString()
        val alamat = update_alamat.text.toString()
        val no_kk = update_no_nik.text

        if (inputCheck(nama_kepala, alamat, no_kk)){
            val updateKeluarga = Keluarga(args.currentFamily.id, nama_kepala, alamat, Integer.parseInt(no_kk.toString()))
            mkeluargaViewModel.updateKeluarga(updateKeluarga)
            Toast.makeText(requireContext(), "Berhasil Mengubah Data!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateKeluarga_to_listKeluarga)

        }else{
            Toast.makeText(requireContext(), "Gagal Mengubah Data!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(nama_kepala:String, alamat:String, no_kk: Editable):Boolean{
        return !(TextUtils.isEmpty(nama_kepala) && TextUtils.isEmpty(alamat) && no_kk.isEmpty())

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            deleteKeluarga()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun deleteKeluarga(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Ya"){ _, _->
            mkeluargaViewModel.deleteKeluarga(args.currentFamily)
            Toast.makeText(requireContext(),"Berhasil Menghapus Data: ${args.currentFamily.nama_kepala}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateKeluarga_to_listKeluarga)
        }
        builder.setNegativeButton("No"){ _, _->}
        builder.setTitle("Hapus ${args.currentFamily.nama_kepala}?")
        builder.setMessage("Apakah yakin akan menghapus ${args.currentFamily.nama_kepala}?")
        builder.create().show()
    }
}

