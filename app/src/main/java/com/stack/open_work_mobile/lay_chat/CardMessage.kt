package com.stack.open_work_mobile.lay_chat

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.databinding.FragmentCardMessageBinding

class CardMessage @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {
    private var cardMessage: String? = null
    private var timer: String? = null

    private val binding = FragmentCardMessageBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?){
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.CardMessage
            )

            val message = attributes.getResourceId(R.styleable.CardMessage_message, 0)
            val timerMessage = attributes.getResourceId(R.styleable.CardMessage_timer, 0)


            if(message != 0 && timerMessage != 0) {
                cardMessage = context.getString(message)
                timer = context.getString(timerMessage)
            }


            attributes.recycle()
        }
    }
}