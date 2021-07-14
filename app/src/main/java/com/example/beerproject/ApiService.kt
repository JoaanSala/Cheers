package com.example.beerproject

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/v2/beers/192")
    fun getBeers() : Call<MutableList<BeerModel.Beer>>
}