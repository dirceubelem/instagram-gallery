package br.com.cotemig.aula06.services

import br.com.cotemig.aula06.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface ServiceFeed {

    @GET("feed")
    fun get(): Call<List<Post>>

}