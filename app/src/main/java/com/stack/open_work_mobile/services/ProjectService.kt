package com.stack.open_work_mobile.services

import com.stack.open_work_mobile.activities.lay_my_projects.ProjectProgressCard
import com.stack.open_work_mobile.activities.lay_my_projects.ProjectProgressCardAdapter
import retrofit2.Call
import retrofit2.http.GET

interface ProjectService {
    @GET("/projetos-aceitos/andamento/desenvolvedor/3")
    fun getAllProgress(): Call<List<ProjectProgressCard>>
}