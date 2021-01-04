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
import com.example.oop2.data.kelahiran.Kelahiran
import com.example.oop2.data.kelahiran.KelahiranViewModel
import com.example.oop2.data.keluarga.Keluarga
import com.example.oop2.data.keluarga.KeluargaViewModel
import kotlinx.android.synthetic.main.fragment_update_kelahiran.*
import kotlinx.android.synthetic.main.fragment_update_kelahiran.view.*
import kotlinx.android.synthetic.main.fragment_update_keluarga.*
import kotlinx.android.synthetic.main.fragment_update_keluarga.view.*

class UpdateKelahiran : Fragment() {
    private val args by navArgs<UpdateKelahiranArgs>()
    private lateinit var mKelahiranViewModel: KelahiranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view2 = inflater.inflate(R.layout.fragment_update_kelahiran, container, false)
        mKelahiranViewModel = ViewModelProvider(this).get(KelahiranViewModel::class.java)

        view2.update_kelahiran.setText(args.currentKelahiran.nama_kelahiran)
        view2.update_berat.setText(args.currentKelahiran.berat.toString())
        view2.update_panjang.setText(args.currentKelahiran.panjang.toString())

        view2.update_btn_kelahiran.setOnClickListener {
            updateKelahiran()
        }
        setHasOptionsMenu(true)
        return view2
    }
    private fun updateKelahiran() {
        val nama_kelahiran = update_kelahiran.text.toString()
        val berat = update_berat.text
        val panjang = update_panjang.text

        if (inputCheck(nama_kelahiran,berat,panjang)){
            val updateKelahiran = Kelahiran(args.currentKelahiran.id, nama_kelahiran, Integer.parseInt(berat.toString()) , Integer.parseInt(panjang.toString()))
            mKelahiranViewModel.updateKelahiran(updateKelahiran)
            Toast.makeText(requireContext(), "Berhasil Mengubah Data!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateKelahiran_to_listKelahiran)

        }else{
            Toast.makeText(requireContext(), "Gagal Mengubah Data!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(nama_keluarga:String, berat:Editable, panjang: Editable):Boolean{
        return !(TextUtils.isEmpty(nama_keluarga) && berat.isEmpty() && panjang.isEmpty())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            deleteKelahiran()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun deleteKelahiran(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Ya"){ _, _->
            mKelahiranViewModel.deleteKelahiran(args.currentKelahiran)
            Toast.makeText(requireContext(),"Berhasil Menghapus Data: ${args.currentKelahiran.nama_kelahiran}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateKelahiran_to_listKelahiran)
        }
        builder.setNegativeButton("No"){ _, _->}
        builder.setTitle("Hapus ${args.currentKelahiran.nama_kelahiran}?")
        builder.setMessage("Apakah yakin akan menghapus ${args.currentKelahiran.nama_kelahiran}?")
        builder.create().show()
    }

}