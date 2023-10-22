package com.stack.open_work_mobile.services
import com.stack.open_work_mobile.models.LoginData
import com.stack.open_work_mobile.models.LoginModel
import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @POST("api/usuarios/login")
    fun entrarLogin(@Body loginData: LoginData): Call<LoginModel>
}