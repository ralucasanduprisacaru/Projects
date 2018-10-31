package com.example.raluc.telegraphchallenge.data.remote

import com.example.raluc.telegraphchallenge.models.Response
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface RemoteService {

    @GET ("tmgmobilepub/articles.json")
fun getPopularMovies(): Deferred<Response>  // deffered is a contract, soemthing you will get in the future
}