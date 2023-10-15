package com.stack.open_work_mobile.services

import android.preference.PreferenceManager
import com.stack.open_work_mobile.activities.lay_home.CardProjectHome
import com.stack.open_work_mobile.activities.lay_my_projects.ProjectProgressCard
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProjectService {

    @GET("/api/projetos-aceitos/andamento/desenvolvedor/3")
    fun getAllProgress(): Call<List<ProjectProgressCard>>

    @GET("/api/projetos-aceitos/completos/desenvolvedor/{userId}")
    fun getAllCompleted(@Path("userId") id: Long): Call<List<ProjectProgressCard>>

    @GET("/api/projetos-aceitos/cancelados/desenvolvedor/3")
    fun getAllCanceled(): Call<List<ProjectProgressCard>>

    @GET("/api/projetos/user/3")
    fun getAllProjectsUserTools(): Call<List<CardProjectHome>>
}