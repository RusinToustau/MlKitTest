package com.prueba.mymlkit

import android.media.Image
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizerOptions
import java.lang.Exception


class ImageAnalyzer(private val listener: Listener) : ImageAnalysis.Analyzer {

    @ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        imageProxy.image?.let { mediaImage ->
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            textRecognition(image)
        }
    }

    fun textRecognition(image: InputImage) {
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        recognizer.process(image)
            .addOnSuccessListener { visionText ->
                // Task completed successfully
                listener.onSuccessListener(visionText)
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                listener.onFailureListener(e)
            }
    }

    interface Listener {
        fun onSuccessListener(visionText: Text)
        fun onFailureListener(e: Exception)
    }
}