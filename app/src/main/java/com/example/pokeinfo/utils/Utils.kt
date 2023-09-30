package com.example.pokeinfo.utils

import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import java.io.Serializable

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// API 33 이후 getSerializable()가 deprecated 되어서 만든 확장함수
fun <T: Serializable> Intent.intentSerializable(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializableExtra(key, clazz)
    } else {
        this.getSerializableExtra(key) as T?
    }
}