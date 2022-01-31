package com.kevinhao426.cryptocurrencylist.utils

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

suspend fun getJsonFromAssets(context: Context, fileName: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            fileName.let {
                val inputStream = context.assets.open(it)
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                inputStream.close()
                String(buffer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
