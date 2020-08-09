package com.example.warungpojok.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.io.ByteArrayOutputStream
import java.io.File

val REQUEST_CODE_PHOTO = 1924
val REQUEST_GALLERY = 1000
val RESULT_OKE = -1

inline fun <reified T : ViewModel> Fragment.fragmentViewModel() = lazy {
    ViewModelProvider(this).get(T::class.java)
}

fun convertToBase64(imagePath: String): String? {
    val bm = BitmapFactory.decodeFile(imagePath)
    val baos = ByteArrayOutputStream()
    bm.compress(Bitmap.CompressFormat.JPEG, 75, baos)
    val byteArrayImage = baos.toByteArray()
    return Base64.encodeToString(byteArrayImage, Base64.DEFAULT)
}