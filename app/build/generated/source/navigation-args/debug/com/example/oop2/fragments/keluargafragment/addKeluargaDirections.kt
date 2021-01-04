package com.example.oop2.fragments.keluargafragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.oop2.R

class addKeluargaDirections private constructor() {
  companion object {
    fun actionAddKeluargaToListKeluarga(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addKeluarga_to_listKeluarga)
  }
}
