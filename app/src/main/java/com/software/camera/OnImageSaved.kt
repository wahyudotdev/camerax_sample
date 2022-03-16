package com.software.camera

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import java.io.File

class OnImageSaved constructor(private val photoFile: File, private val context: Context) :
    ImageCapture.OnImageSavedCallback {
    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
        val saveUri = Uri.fromFile(photoFile)
        val msg = "Photo saved in $saveUri"
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onError(exception: ImageCaptureException) {
        Log.e(Constants.TAG, "onError: ${exception.message}", exception)
    }
}