package com.example.oop2.fragments.update

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.oop2.data.kelahiran.Kelahiran
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class UpdateKelahiranArgs(
  val currentKelahiran: Kelahiran
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): UpdateKelahiranArgs {
      bundle.setClassLoader(UpdateKelahiranArgs::class.java.classLoader)
      val __currentKelahiran : Kelahiran?
      if (bundle.containsKey("currentKelahiran")) {
        if (Parcelable::class.java.isAssignableFrom(Kelahiran::class.java) ||
            Serializable::class.java.isAssignableFrom(Kelahiran::class.java)) {
          __currentKelahiran = bundle.get("currentKelahiran") as Kelahiran?
        } else {
          throw UnsupportedOperationException(Kelahiran::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentKelahiran == null) {
          throw IllegalArgumentException("Argument \"currentKelahiran\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentKelahiran\" is missing and does not have an android:defaultValue")
      }
      return UpdateKelahiranArgs(__currentKelahiran)
    }
  }
}
