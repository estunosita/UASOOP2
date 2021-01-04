package com.example.oop2.fragments.update

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.oop2.data.keluarga.Keluarga
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class updateKeluargaArgs(
  val currentFamily: Keluarga
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): updateKeluargaArgs {
      bundle.setClassLoader(updateKeluargaArgs::class.java.classLoader)
      val __currentFamily : Keluarga?
      if (bundle.containsKey("currentFamily")) {
        if (Parcelable::class.java.isAssignableFrom(Keluarga::class.java) ||
            Serializable::class.java.isAssignableFrom(Keluarga::class.java)) {
          __currentFamily = bundle.get("currentFamily") as Keluarga?
        } else {
          throw UnsupportedOperationException(Keluarga::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentFamily == null) {
          throw IllegalArgumentException("Argument \"currentFamily\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentFamily\" is missing and does not have an android:defaultValue")
      }
      return updateKeluargaArgs(__currentFamily)
    }
  }
}
