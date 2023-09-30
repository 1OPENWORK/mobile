package com.stack.open_work_mobile.services

import com.stack.open_work_mobile.activities.lay_my_projects.ProjectProgressCardAdapter
import retrofit2.Call
import retrofit2.http.GET

interface ProjectService {

    @GET("/projetos-aceitos/andamento/")
    fun getAllCompleted(): Call<ProjectProgressCardAdapter>
}