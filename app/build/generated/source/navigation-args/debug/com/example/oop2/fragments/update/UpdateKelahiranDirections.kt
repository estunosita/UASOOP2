package com.example.oop2.fragments.update

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.oop2.R

class UpdateKelahiranDirections private constructor() {
  companion object {
    fun actionUpdateKelahiranToListKelahiran(): NavDirections =
        ActionOnlyNavDirections(R.id.action_updateKelahiran_to_listKelahiran)
  }
}
