package com.example.quickwebview

import android.util.Patterns

object UrlValidator {

    fun validate(input: String): String? {
        val text = input.trim()
        if (text.isEmpty()) return null

        val url =
            if (text.startsWith("http://") || text.startsWith("https://"))
                text
            else
                "https://$text"

        return if (Patterns.WEB_URL.matcher(url).matches()) url else null
    }
}
