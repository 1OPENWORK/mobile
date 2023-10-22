package com.stack.open_work_mobile.activities.lay_login
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.api.Rest
import com.stack.open_work_mobile.services.LoginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.stack.open_work_mobile.databinding.ActivityLoginBinding
import com.stack.open_work_mobile.activities.lay_home.HomeActivity
import com.stack.open_work_mobile.models.LoginData
import com.stack.open_work_mobile.models.LoginModel
import com.stack.open_work_mobile.obj.InfoUser
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class   LoginActivity : AppCompatActivity() {

    private var loginService: LoginService? = null
    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureGoogleSignIn()

        val retrofit = Rest.getInstance()
        if (retrofit != null) {
            loginService = retrofit.create(LoginService::class.java)
        } else {
            "Erro no retrofit ou ec2"
        }

        binding.btnGoogleLogin.setOnClickListener {
            signInWithGoogle()
        }



        binding.btnLogin.setOnClickListener {
            val email: String = binding.emailInput.editText?.text.toString()
            val password: String = binding.senhaInput.editText?.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                exibirSnackbar("Preencha os campos, email e senha")
                // testando com email que não tem o .com
                //ligar verificação depois.
//            } else if (!Util.isValidEmail(email)) {
//                exibirSnackbar("E-mail inválido")
            } else if (password.length < 6) {
                exibirSnackbar("Senha deve ter no mínimo 6 caracteres")
            } else {
                val loginData = LoginData(
                    email = email,
                    senha = password
                )
                fazerChamadaApi(loginData)
            }
        }
    }

    private fun configureGoogleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestProfile()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
        if (it.resultCode == Activity.RESULT_OK) {

            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            if (task.isSuccessful) {
                val idTokenUsrGoogle = task.result.idToken.toString()
                val emailUsrGoogle = task.result.email.toString()
                val imgUsrGoogle = task.result.photoUrl.toString()
                val nomeUsrGoogle = task.result.displayName.toString()

                navMainState()
            } else {
                exibirSnackbar("Login com o Google Falhou. Código de erro: ${task.exception?.message}")
            }
        } else {
            exibirSnackbar("Login com o Google Falhou. Código de erro: ${it.resultCode}")
        }
    }

    private fun fazerChamadaApi(loginData: LoginData) {
        if (loginService == null) {
            exibirSnackbar("Problema na service, NULA")
            return
        }

        val call = loginService!!.entrarLogin(loginData)

        call.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                if (response.isSuccessful) {
                    val seuModel = response.body()
                    InfoUser.userId = seuModel?.userId
                    InfoUser.nome = seuModel?.nome
                    InfoUser.email = seuModel?.email
                    InfoUser.tipo = seuModel?.tipo
                    InfoUser.token = seuModel?.token
                    InfoUser.companyId = seuModel?.companyId

                    exibirSnackbar("Seja bem vindo: ${seuModel?.nome}")
                    Handler(Looper.getMainLooper()).postDelayed({
                        navMainState()
                        Snackbar.make(binding.root, "Login efetuado com sucesso!", Snackbar.LENGTH_SHORT).show()
                    }, 1000)

                } else {
                    when (response.code()) {
                        403 -> exibirSnackbar("Campos incorretos")
                        else -> exibirSnackbar("Erro na chamada: ${response.code()}")
                    }
                }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                exibirSnackbar("Erro na chamada: ${t.message}")
            }
        })
    }

    private fun exibirSnackbar(mensagem: String) {
        Snackbar.make(
            binding.root,
            mensagem,
            Snackbar.LENGTH_SHORT
        ).show()
    }


    private fun navMainState() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}