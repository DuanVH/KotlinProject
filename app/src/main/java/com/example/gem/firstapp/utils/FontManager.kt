package com.example.gem.firstapp.utils

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView

class FontManager {

    private var fonts: HashMap<String, Typeface>? = null
    companion object {
        var sInstance: FontManager? = null

        fun getInstance(): FontManager {
            if (sInstance == null) {
                synchronized(FontManager::class.java) {
                    if (sInstance == null) {
                        sInstance = FontManager()
                    }
                }
            }
            return sInstance!!
        }
    }

    constructor() {
        fonts = HashMap()
    }

    fun getFont(context: Context, fontPath: String): Typeface {
        if (!fonts!!.containsKey(fontPath)) {
            var typeface: Typeface = Typeface.createFromAsset(context.assets, fontPath)
            fonts!!.put(fontPath, typeface)
        }
        return fonts!!.get(fontPath)!!
    }

    fun setFonts(context: Context, fontPath: String, textView: TextView) {
        var typeface: Typeface = getFont(context, fontPath)
        if (typeface != null)
            textView!!.setTypeface(typeface)!!
    }
}