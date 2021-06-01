package com.prueba.mymlkit

import android.content.Context
import android.net.Uri
import com.google.mlkit.vision.common.InputImage
import java.io.IOException

object InputImageWrapper {

    fun imageFromPath(context: Context, uri: Uri) : InputImage? {
        // [START image_from_path]
        var image: InputImage? = null
        try {
            image = InputImage.fromFilePath(context, uri)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }

}