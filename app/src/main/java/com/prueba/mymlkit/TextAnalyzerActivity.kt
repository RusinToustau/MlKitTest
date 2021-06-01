package com.prueba.mymlkit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.net.Uri
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.vision.text.Text
import com.prueba.mymlkit.CameraActivity.Companion.REQUEST_CODE
import com.prueba.mymlkit.CameraActivity.Companion.URI_RESULT
import kotlinx.android.synthetic.main.activity_text_analyzer.*
import java.lang.Exception

class TextAnalyzerActivity : AppCompatActivity(R.layout.activity_text_analyzer), ImageAnalyzer.Listener {

    private lateinit var imageAnalyzer: ImageAnalyzer
    private var resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == REQUEST_CODE) {
            val imageUri = Uri.parse(result.data?.getStringExtra(URI_RESULT))
            showImage(imageUri as Uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        takePictureButton.setOnClickListener { openCameraForResult() }

        imageAnalyzer = ImageAnalyzer(this)
    }

    private fun openCameraForResult() {
        val intent = Intent(this, CameraActivity::class.java)
        resultLauncher.launch(intent)
    }

    @SuppressLint("UnsafeOptInUsageError")
    private fun showImage(imageUri: Uri) {
        InputImageWrapper.imageFromPath(this, imageUri)?.let { image ->
            imageView.setImageBitmap(image.bitmapInternal)
            imageAnalyzer.textRecognition(image)
        }
    }

    override fun onSuccessListener(visionText: Text) {
        textView.text = visionText.text
    }

    override fun onFailureListener(e: Exception) {
        Toast.makeText(baseContext, e.message, Toast.LENGTH_SHORT).show()
    }

}