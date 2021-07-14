package com.example.beerproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class BeerListFragment : Fragment(){

    private lateinit var viewOfLayout: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.beerlist_fragment, container, false)

        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getBeers()

        val button = viewOfLayout.findViewById<Button>(R.id.request)

        button.setOnClickListener{
            MainActivity().request(call, serviceGenerator)
        }

        return viewOfLayout
    }

}