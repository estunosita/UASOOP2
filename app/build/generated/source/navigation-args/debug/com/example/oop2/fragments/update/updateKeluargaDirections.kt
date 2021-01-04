package com.example.oop2.fragments.update

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.oop2.R

class updateKeluargaDirections private constructor() {
  companion object {
    fun actionUpdateKeluargaToListKeluarga(): NavDirections =
        ActionOnlyNavDirections(R.id.action_updateKeluarga_to_listKeluarga)
  }
}
