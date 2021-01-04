package com.example.oop2.fragments.kelahiranfragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.oop2.R

class AddKelahiranDirections private constructor() {
  companion object {
    fun actionAddKelahiranToListKelahiran(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addKelahiran_to_listKelahiran)
  }
}
