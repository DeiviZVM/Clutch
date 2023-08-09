package com.android.clutch.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.android.clutch.R

class FavoriteComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr){

    private val imageView: ImageView

    var checked: Boolean = false
        set(value) {
            field = value
            selectImage()
        }

    init {
        imageView = inflate(context, R.layout.component_heart, this)
            .findViewById(R.id.iv_heart)
    }

    private fun selectImage() = imageView.setImageResource(
        if (checked) {
            R.drawable.heart_complete
        } else {
            R.drawable.heart
        }
    )
}