package com.example.oop2.fragments.kelahiranfragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop2.R
import com.example.oop2.data.kelahiran.KelahiranViewModel
import kotlinx.android.synthetic.main.fragment_list_kelahiran.view.*

class ListKelahiran : Fragment() {

    private lateinit var mKelahiranViewModel: KelahiranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view2 =  inflater.inflate(R.layout.fragment_list_kelahiran, container, false)

        val adapter = ListKelahiranAdapter()
        val recyclerView = view2.recycleView2
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mKelahiranViewModel = ViewModelProvider(this).get(KelahiranViewModel::class.java)
        mKelahiranViewModel.readAllkelahiran.observe(viewLifecycleOwner, Observer {kelahiran ->
            adapter.setData(kelahiran)

        })

        view2.floatingActionButton2.setOnClickListener {
            findNavController().navigate(R.id.action_listKelahiran_to_addKelahiran)
        }
        setHasOptionsMenu(true)
        return view2
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            deleteAllKelahiran()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllKelahiran() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mKelahiranViewModel.deleteAllKelahiran()
            Toast.makeText(
                requireContext(),
                "Berhasil Menghapus Semua Data Kelahiran",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Menghapus Semua Data")
        builder.setMessage("Apakah yakin akan menghapus semua data?")
        builder.create().show()
    }

}