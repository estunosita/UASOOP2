package com.example.oop2.fragments.kelahiranfragment

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.oop2.R
import com.example.oop2.data.kelahiran.Kelahiran
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class ListKelahiranDirections private constructor() {
  private data class ActionListKelahiranToUpdateKelahiran(
    val currentKelahiran: Kelahiran
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_listKelahiran_to_updateKelahiran

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Kelahiran::class.java)) {
        result.putParcelable("currentKelahiran", this.currentKelahiran as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Kelahiran::class.java)) {
        result.putSerializable("currentKelahiran", this.currentKelahiran as Serializable)
      } else {
        throw UnsupportedOperationException(Kelahiran::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionListKelahiranToPilih2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listKelahiran_to_pilih2)

    fun actionListKelahiranToAddKelahiran(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listKelahiran_to_addKelahiran)

    fun actionListKelahiranToUpdateKelahiran(currentKelahiran: Kelahiran): NavDirections =
        ActionListKelahiranToUpdateKelahiran(currentKelahiran)
  }
}
