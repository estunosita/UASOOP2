package com.example.oop2.fragments.keluargafragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop2.R
import com.example.oop2.data.keluarga.KeluargaViewModel
import kotlinx.android.synthetic.main.fragment_list_keluarga.view.*

class listKeluarga : Fragment() {
    private lateinit var mKeluargaModelView: KeluargaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list_keluarga, container, false)
        val adapter = ListKeluargaAdapter()
        val recyclerView = view.recycleView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mKeluargaModelView = ViewModelProvider(this).get(KeluargaViewModel::class.java)
        mKeluargaModelView.readAllKeluarga.observe(viewLifecycleOwner, Observer {keluarga ->
        adapter.setDataKeluarga(keluarga)

        })


        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listKeluarga_to_addKeluarga)
        }
        setHasOptionsMenu(true)
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            deleteAllKeluarga()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllKeluarga() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mKeluargaModelView.deleteAllKeluarga()
            Toast.makeText(
                requireContext(),
                "Berhasil Menghapus Semua Data",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Menghapus Semua Data")
        builder.setMessage("Apakah yakin akan menghapus semua data?")
        builder.create().show()
    }

}
