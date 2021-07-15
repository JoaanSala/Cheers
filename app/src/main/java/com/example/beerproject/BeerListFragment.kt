package com.example.beerproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.VerifiedInputEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeerListFragment : Fragment(){

    private lateinit var viewOfLayout: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BeerAdapter

    private lateinit var previousPage: Button
    private lateinit var nextPage: Button
    private lateinit var numpage: TextView

    var pagecount: Int = 1
    var pagesize: Int = 80
    val howManyBeers: Int = 325

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.beerlist_fragment, container, false)

        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getBeers(pagecount, pagesize)

        previousPage = viewOfLayout.findViewById<Button>(R.id.leftPage)
        nextPage = viewOfLayout.findViewById<Button>(R.id.rightPage)
        numpage = viewOfLayout.findViewById<TextView>(R.id.beerPage)

        previousPage.setOnClickListener{
            pagecount--
            if(pagecount==1){
                previousPage.visibility = View.INVISIBLE
                previousPage.isClickable = false
            }
            if(pagecount < (howManyBeers/pagesize)+1){
                nextPage.visibility = View.VISIBLE
                nextPage.isClickable = true
            }
            numpage.text = pagecount.toString()
            val call = serviceGenerator.getBeers(pagecount, pagesize)
            request(call, serviceGenerator)

        }
        nextPage.setOnClickListener{
            pagecount++
            if(pagecount==2){
                previousPage.visibility = View.VISIBLE
                previousPage.isClickable = true
            }
            if(pagecount == (howManyBeers/pagesize)+1){
                nextPage.visibility = View.INVISIBLE
                nextPage.isClickable = false
            }
            numpage.text = pagecount.toString()
            val call = serviceGenerator.getBeers(pagecount, pagesize)
            request(call, serviceGenerator)

        }

        recyclerView = viewOfLayout.findViewById<RecyclerView>(R.id.beerRecyclerView)

        request(call, serviceGenerator)

        return viewOfLayout
    }

    private fun request(call: Call<MutableList<BeerModel.Beer>>, serviceGenerator: ApiService){
        call.enqueue(object : Callback<MutableList<BeerModel.Beer>> {
            override fun onResponse(
                call: Call<MutableList<BeerModel.Beer>>, response: Response<MutableList<BeerModel.Beer>>
            ) {
                if(response.isSuccessful){
                    initRecyclerView(response.body()!!)
                }
            }
            override fun onFailure(call: Call<MutableList<BeerModel.Beer>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })
    }

    private fun initRecyclerView(response: MutableList<BeerModel.Beer>) {

        recyclerView.setHasFixedSize(true)
        adapter = BeerAdapter(response)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

    }



}