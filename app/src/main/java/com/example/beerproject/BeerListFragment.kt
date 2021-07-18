package com.example.beerproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beerproject.API.ApiService
import com.example.beerproject.API.ServiceGenerator
import com.example.beerproject.Adapter.BeerAdapter
import com.example.beerproject.Model.BeerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class BeerListFragment : Fragment(), BeerAdapter.OnItemClickListener{

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
        adapter = BeerAdapter(response, this)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(beer: BeerModel.Beer, position: Int) {
        val intent = Intent(context, BeerInfoActivity::class.java)

        intent.putExtra("id", beer.id.toString())
        intent.putExtra("name", beer.name)
        intent.putExtra("tagline", beer.tagline)
        intent.putExtra("first_brewed", beer.first_brewed)
        intent.putExtra("description", beer.description)
        intent.putExtra("image_url", beer.image_url)
        intent.putExtra("abv", beer.abv.toString())
        intent.putExtra("ibu", beer.ibu.toString())
        intent.putExtra("target_fg", beer.target_fg.toString())
        intent.putExtra("target_og", beer.target_og.toString())
        intent.putExtra("ebc", beer.ebc.toString())
        intent.putExtra("srm", beer.srm.toString())
        intent.putExtra("ph", beer.ph.toString())
        intent.putExtra("attenuation_level", beer.attenuation_level.toString())

        val maltNames = arrayListOf<String>()
        val maltValues = arrayListOf<String>()

        for (i in beer.ingredients.malt.indices) {
            maltNames.add(beer.ingredients.malt[i].name)
            maltValues.add(beer.ingredients.malt[i].amount.value.toString() + " kg")
        }

        val hopsNames = arrayListOf<String>()
        val hopsValues = arrayListOf<String>()

        for (i in beer.ingredients.hops.indices) {
            hopsNames.add(beer.ingredients.hops[i].name + " ("+beer.ingredients.hops[i].add + " "+beer.ingredients.hops[i].attribute+")")
            hopsValues.add(beer.ingredients.hops[i].amount.value.toString() + " g")
        }

        intent.putStringArrayListExtra("malt_names", maltNames)
        intent.putStringArrayListExtra("malt_values", maltValues)
        intent.putStringArrayListExtra("hops_names", hopsNames)
        intent.putStringArrayListExtra("hops_values", hopsValues)

        if(beer.food_pairing.size >= 1) {
            intent.putExtra("food_pairing1", beer.food_pairing[0])
        }
        if(beer.food_pairing.size >= 2){
            intent.putExtra("food_pairing2", beer.food_pairing[1])
        }
        if(beer.food_pairing.size >= 3){
            intent.putExtra("food_pairing3", beer.food_pairing[2])
        }
        
        startActivity(intent)
    }

}
