package com.stack.open_work_mobile.lay_login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.databinding.ActivityLoginBinding
import com.stack.open_work_mobile.lay_home.HomeActivity
import com.stack.open_work_mobile.utils.Util

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val email: String = binding.emailInput.editText?.text.toString()
            val pass: String = binding.senhaInput.editText?.text.toString()


            when {

                email.isEmpty() -> {
                    binding.emailInput.error = "Preencha seu e-mail"
                }

                pass.isEmpty() -> {
                    binding.senhaInput.error = "Coloque sua senha"
                }

                !Util.isValidEmail(email) -> {
                    Snackbar.make(
                        it,
                        "E-mail inválido",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                pass.length <= 6 -> {
                    Snackbar.make(
                        it,
                        "Senha deve ter no mínimo 6 caracteres",
                        Snackbar.LENGTH_SHORT
                    ).show()

                }

                else -> login(it)

            }

        }

    }

    private fun login(view: View) {

//        val loadProgress = binding.progressBar
//        loadProgress.visibility = View.VISIBLE
//
//        binding.buttonLogin.isEnabled = false
//        binding.buttonLogin.setTextColor(Color.parseColor("#FFFFFF"))


        Handler(Looper.getMainLooper()).postDelayed({
            navMainState()
            Snackbar.make(view, "Login efetuado com sucesso!", Snackbar.LENGTH_SHORT).show()
        }, 100)
    }


    private fun navMainState() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}


