package com.example.beerproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.beerproject.Dialog.IngredientsFragment
import com.example.beerproject.Model.BeerModel
import java.io.Serializable

class BeerInfoFragment() : Fragment() {

    private lateinit var viewOfLayout: View

    private lateinit var id_beer: TextView
    private lateinit var name_beer: TextView
    private lateinit var tagline_beer: TextView
    private lateinit var firstbrewed_beer: TextView
    private lateinit var image_beer: ImageView

    private lateinit var description: TextView
    private lateinit var final_gravity: TextView
    private lateinit var original_gravity: TextView
    private lateinit var abv: TextView
    private lateinit var atenuation: TextView
    private lateinit var ebc: TextView
    private lateinit var ph: TextView

    private lateinit var btn_ingredients: Button

    private lateinit var foodpairing1: TextView
    private lateinit var foodpairing2: TextView
    private lateinit var foodpairing3: TextView
    
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.beerinfo_fragment, container, false)

        id_beer = viewOfLayout.findViewById(R.id.beerInfo_id)
        name_beer = viewOfLayout.findViewById(R.id.beerInfo_name)
        tagline_beer = viewOfLayout.findViewById(R.id.beerInfo_tagline)
        firstbrewed_beer = viewOfLayout.findViewById(R.id.beerInfo_firstBrewed)
        image_beer = viewOfLayout.findViewById(R.id.beerInfo_image)
        description = viewOfLayout.findViewById(R.id.beerInfo_description)
        final_gravity = viewOfLayout.findViewById(R.id.beerInfo_fg)
        original_gravity = viewOfLayout.findViewById(R.id.beerInfo_og)
        abv = viewOfLayout.findViewById(R.id.beerInfo_abv)
        atenuation = viewOfLayout.findViewById(R.id.beerInfo_atenuation)
        ebc = viewOfLayout.findViewById(R.id.beerInfo_ebc)
        ph = viewOfLayout.findViewById(R.id.beerInfo_ph)

        btn_ingredients = viewOfLayout.findViewById(R.id.button_Ingredients)

        foodpairing1 = viewOfLayout.findViewById(R.id.beerInfo_foodpairing1)
        foodpairing2 = viewOfLayout.findViewById(R.id.beerInfo_foodpairing2)
        foodpairing3 = viewOfLayout.findViewById(R.id.beerInfo_foodpairing3)

        val beer = requireActivity().intent.extras!!.get("extra_beer") as BeerModel.Beer

        id_beer.text = beer.id.toString()
        name_beer.text = beer.name
        tagline_beer.text = beer.tagline
        firstbrewed_beer.text = beer.first_brewed

        if(beer.image_url == null){
            Glide.with(requireContext()).load(R.drawable.empty).fitCenter().into(image_beer)
        }else{
            Glide.with(requireContext()).load(beer.image_url).fitCenter().into(image_beer)
        }

        description.text = beer.description

        final_gravity.text = beer.target_fg.toString()
        original_gravity.text = beer.target_og.toString()
        abv.text = beer.abv.toString()
        atenuation.text = beer.attenuation_level.toString()
        ebc.text = beer.ebc.toString()
        ph.text = beer.ph.toString()

        if(beer.food_pairing.size > 0) {
            foodpairing1.text = "-> " + beer.food_pairing[0]
        }else{
            foodpairing1.visibility = View.INVISIBLE
        }
        if(beer.food_pairing.size > 1){
            foodpairing2.text = "-> "+beer.food_pairing[1]
        }else{
            foodpairing2.visibility = View.INVISIBLE
        }
        if(beer.food_pairing.size > 2) {
            foodpairing3.text = "-> " + beer.food_pairing[2]
        }else{
            foodpairing3.visibility = View.INVISIBLE
        }

        btn_ingredients.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("extra_beer", beer as Serializable)

            val ingredientsFragment = IngredientsFragment()
            ingredientsFragment.arguments = bundle
            ingredientsFragment.show(requireActivity().supportFragmentManager, "beerDialog")
        })

        return viewOfLayout
    }
}