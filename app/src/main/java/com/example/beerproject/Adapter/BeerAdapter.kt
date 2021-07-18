package com.example.beerproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beerproject.Model.BeerModel
import com.example.beerproject.R

class BeerAdapter(val beerModel: MutableList<BeerModel.Beer>, private val listener: OnItemClickListener): RecyclerView.Adapter<BeerAdapter.BeerViewHolder>(){

    interface OnItemClickListener{
        fun onItemClick(beer: BeerModel.Beer, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_beer, parent, false)
        return BeerViewHolder(v)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        return holder.bindView(beerModel[position])
    }

    override fun getItemCount(): Int {
        return beerModel.size
    }

    inner class BeerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private lateinit var beer: BeerModel.Beer
        private val beerImage: ImageView = itemView.findViewById(R.id.imageBeer)
        private val beerName: TextView = itemView.findViewById(R.id.nameBeer)
        private val beerTagLine: TextView = itemView.findViewById(R.id.beerTagline)

        fun bindView(beer: BeerModel.Beer){
            this.beer = beer
            var imageURL = beer.image_url
            if(imageURL == null){
                Glide.with(itemView.context).load(R.drawable.empty).fitCenter().into(beerImage)
            }else {
                Glide.with(itemView.context).load(imageURL).fitCenter().into(beerImage)
            }
            beerName.text = beer.id.toString()+ ":  " + beer.name
            beerTagLine.text = beer.tagline
        }

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(beer, position)
            }
        }
    }
}