package com.example.gem.firstapp.widget

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.AppCompatEditText
import android.text.TextUtils
import android.util.AttributeSet
import com.example.gem.firstapp.R
import com.example.gem.firstapp.utils.FontManager

class MyEditText : AppCompatEditText {

    private var mEtFontPath: String? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        if (attributeSet != null) {
            var typeArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyTextView)
            mEtFontPath = typeArray.getString(R.styleable.MyTextView_font_path)
            typeArray.recycle()
        }
        if (TextUtils.isEmpty(mEtFontPath))
            mEtFontPath = "fonts/SFUIText-Regular.otf"

        setTypeface(FontManager.getInstance().getFont(getContext(), mEtFontPath!!))
    }

    fun setFont(fontPath: String) {
        mEtFontPath = fontPath
        setTypeface(FontManager.getInstance().getFont(context, mEtFontPath!!))
    }
}