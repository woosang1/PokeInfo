package com.example.pokeinfo.utils

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import java.io.Serializable

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.getDeviceHeight() : Int{
    val displayMetrics = DisplayMetrics()
    (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
}

fun EditText.focusOn() {
    this.run {
        isFocusableInTouchMode = true
        requestFocus()
        showKeyBoard()
    }
}

fun EditText.focusOff() {
    this.run {
        isFocusableInTouchMode = false
        isFocusable = false
        Handler(Looper.getMainLooper()).postDelayed({
            isFocusableInTouchMode = true
            isFocusable = true
        }, 1000)
    }
}

fun EditText.showKeyBoard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

// API 33 이후 getSerializable()가 deprecated 되어서 만든 확장함수
fun <T: Serializable> Intent.intentSerializable(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializableExtra(key, clazz)
    } else {
        this.getSerializableExtra(key) as T?
    }
}