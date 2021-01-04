package com.example.oop2.fragments.keluargafragment

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.oop2.R
import com.example.oop2.data.keluarga.Keluarga
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class listKeluargaDirections private constructor() {
  private data class ActionListKeluargaToUpdateKeluarga(
    val currentFamily: Keluarga
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_listKeluarga_to_updateKeluarga

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Keluarga::class.java)) {
        result.putParcelable("currentFamily", this.currentFamily as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Keluarga::class.java)) {
        result.putSerializable("currentFamily", this.currentFamily as Serializable)
      } else {
        throw UnsupportedOperationException(Keluarga::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionListKeluargaToPilih2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listKeluarga_to_pilih2)

    fun actionListKeluargaToAddKeluarga(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listKeluarga_to_addKeluarga)

    fun actionListKeluargaToUpdateKeluarga(currentFamily: Keluarga): NavDirections =
        ActionListKeluargaToUpdateKeluarga(currentFamily)
  }
}
