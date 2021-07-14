package com.example.beerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_main, LoadingFragment()).commit()
    }

    fun request(call: Call<MutableList<BeerModel.Beer>>, serviceGenerator: ApiService){
        call.enqueue(object : Callback<MutableList<BeerModel.Beer>> {
            override fun onResponse(
                call: Call<MutableList<BeerModel.Beer>>, response: Response<MutableList<BeerModel.Beer>>
            ) {
                if(response.isSuccessful){
                    Log.e("pppp", response.body().toString())
                }
            }
            override fun onFailure(call: Call<MutableList<BeerModel.Beer>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })
    }
}
