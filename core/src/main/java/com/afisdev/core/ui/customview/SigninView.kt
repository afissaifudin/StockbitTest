package com.afisdev.core.ui.customview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.afisdev.core.R
import kotlinx.android.synthetic.main.signin_view.view.*

class SigninView constructor(
    context: Context,
    private val attributeSet: AttributeSet
): FrameLayout(context, attributeSet) {

    init {
        View.inflate(context, R.layout.signin_view, this)
        bindView()
    }

    @SuppressLint("Recycle")
    private fun bindView() {
        val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.SigninView)
        val title = attributes.getString(R.styleable.SigninView_title)
        val image = attributes.getDrawable(R.styleable.SigninView_icon)

        signinViewTextView.text = title
        signinViewImageview.setImageDrawable(image)
    }


}