package com.example.beerproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

public interface ApiService{

    @GET("v2/beers")
    fun getBeers(@Query("page") page: Int, @Query("per_page") pagesize:Int): Call<MutableList<BeerModel.Beer>>


}