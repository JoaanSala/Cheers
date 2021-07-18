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

class BeerInfoFragment : Fragment() {

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


        val intent = requireActivity().intent

        id_beer.text = intent.getStringExtra("id")

        name_beer.text = intent.getStringExtra("name")
        tagline_beer.text = intent.getStringExtra("tagline")
        firstbrewed_beer.text = intent.getStringExtra("first_brewed")

        if(intent.getStringExtra("image_url") == null){
            Glide.with(requireContext()).load(R.drawable.empty).fitCenter().into(image_beer)
        }else{
            Glide.with(requireContext())
                .load(intent.getStringExtra("image_url"))
                .fitCenter()
                .into(image_beer)
        }

        description.text = intent.getStringExtra("description")

        final_gravity.text = intent.getStringExtra("target_fg")
        original_gravity.text = intent.getStringExtra("target_og")
        abv.text = intent.getStringExtra("abv")
        atenuation.text = intent.getStringExtra("attenuation_level")
        ebc.text = intent.getStringExtra("ebc")
        ph.text = intent.getStringExtra("ph")

        btn_ingredients.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("malt_names", intent.getStringArrayListExtra("malt_names"))
            bundle.putStringArrayList("malt_values", intent.getStringArrayListExtra("malt_values"))
            bundle.putStringArrayList("hops_names", intent.getStringArrayListExtra("hops_names"))
            bundle.putStringArrayList("hops_values", intent.getStringArrayListExtra("hops_values"))

            val ingredientsFragment = IngredientsFragment()
            ingredientsFragment.arguments = bundle
            ingredientsFragment.show(requireActivity().supportFragmentManager, "beerDialog")
        })

        if(intent.getStringExtra("food_pairing1") != null) {
            foodpairing1.visibility = View.INVISIBLE
        }else{
            foodpairing1.text = "-> " + intent.getStringExtra("food_pairing1")
        }
        if(intent.getStringExtra("food_pairing2") == null){
            foodpairing2.visibility = View.INVISIBLE
        }else{
            foodpairing2.text = "-> "+intent.getStringExtra("food_pairing2")
        }
        if(intent.getStringExtra("food_pairing3") == null) {
            foodpairing3.visibility = View.INVISIBLE
        }else{
            foodpairing3.text = "-> " + intent.getStringExtra("food_pairing3")
        }

        return viewOfLayout
    }
}