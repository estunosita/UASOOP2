package com.example.oop2.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.oop2.R

class PilihDirections private constructor() {
  companion object {
    fun actionPilih2ToListKeluarga(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pilih2_to_listKeluarga)

    fun actionPilih2ToListKelahiran(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pilih2_to_listKelahiran)
  }
}
