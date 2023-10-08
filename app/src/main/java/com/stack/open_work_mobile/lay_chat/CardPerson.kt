package com.stack.open_work_mobile.lay_chat

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.databinding.FragmentCardPersonChatBinding

class CardPerson @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

    private var nomePerson: String? = null
    private var message: String? = null
    private var imageUser: String? = null
    private var timer: String? = null

    private val binding = FragmentCardPersonChatBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?){
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.CardPerson
            )

            val nomePersonResId = attributes.getResourceId(R.styleable.CardPerson_nome_person, 0)
            val imagePersonResId = attributes.getResourceId(R.styleable.CardPerson_img, 0)
            val timerResId = attributes.getResourceId(R.styleable.CardPerson_timer, 0)
            val messageResId = attributes.getResourceId(R.styleable.CardPerson_message, 0)

            if(nomePersonResId != 0 && imagePersonResId != 0 && timerResId != 0) {
                nomePerson = context.getString(nomePersonResId)
                imageUser = context.getString(imagePersonResId)
                timer = context.getString(timerResId)
            }

            if(messageResId != 0){
                message = context.getString(messageResId)
            }else {
                message = "A Conversa está vázia."
            }

            attributes.recycle()
        }
    }
}