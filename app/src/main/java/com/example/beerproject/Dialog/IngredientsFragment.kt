package com.example.beerproject.Dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.beerproject.Model.BeerModel
import com.example.beerproject.R


class IngredientsFragment : DialogFragment() {

    private lateinit var viewOfLayout: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return createDialogBeer()
    }

    private fun createDialogBeer(): AlertDialog{
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val v = inflater.inflate(R.layout.ingredients_fragment, null)
        builder.setView(v)

        val btn_close = v.findViewById<ImageView>(R.id.btn_back_ingr)

        val beer = arguments?.getSerializable("extra_beer") as BeerModel.Beer

        initMalt(beer, v)
        initHops(beer, v)

        btn_close.setOnClickListener(View.OnClickListener {
            dismiss()
        })

        return builder.create()
    }

    private fun initMalt(beer: BeerModel.Beer, v: View) {
        //Malt LinearLayout
        val linear_malt1 = v.findViewById<LinearLayout>(R.id.linear_malt1)
        val linear_malt2 = v.findViewById<LinearLayout>(R.id.linear_malt2)
        val linear_malt3 = v.findViewById<LinearLayout>(R.id.linear_malt3)
        val linear_malt4 = v.findViewById<LinearLayout>(R.id.linear_malt4)
        val linear_malt5 = v.findViewById<LinearLayout>(R.id.linear_malt5)
        val linear_malt6 = v.findViewById<LinearLayout>(R.id.linear_malt6)
        val linear_malt7 = v.findViewById<LinearLayout>(R.id.linear_malt7)

        //Malt List
        val title_malt1 = v.findViewById<TextView>(R.id.malt1_title)
        val title_malt2 = v.findViewById<TextView>(R.id.malt2_title)
        val title_malt3 = v.findViewById<TextView>(R.id.malt3_title)
        val title_malt4 = v.findViewById<TextView>(R.id.malt4_title)
        val title_malt5 = v.findViewById<TextView>(R.id.malt5_title)
        val title_malt6 = v.findViewById<TextView>(R.id.malt6_title)
        val title_malt7 = v.findViewById<TextView>(R.id.malt7_title)

        val data_malt1 = v.findViewById<TextView>(R.id.malt1_data)
        val data_malt2 = v.findViewById<TextView>(R.id.malt2_data)
        val data_malt3 = v.findViewById<TextView>(R.id.malt3_data)
        val data_malt4 = v.findViewById<TextView>(R.id.malt4_data)
        val data_malt5 = v.findViewById<TextView>(R.id.malt5_data)
        val data_malt6 = v.findViewById<TextView>(R.id.malt6_data)
        val data_malt7 = v.findViewById<TextView>(R.id.malt7_data)

        if(beer.ingredients.malt.size > 0){
            title_malt1.text = beer.ingredients.malt[0].name
            data_malt1.text = beer.ingredients.malt[0].amount.value.toString()+" "+beer.ingredients.malt[0].amount.unit
        }else{
            linear_malt1.visibility = View.INVISIBLE
        }
        if(beer.ingredients.malt.size > 1){
            title_malt2.text = beer.ingredients.malt[1].name
            data_malt2.text = beer.ingredients.malt[1].amount.value.toString()+" "+beer.ingredients.malt[1].amount.unit
        }else{
            linear_malt2.visibility = View.INVISIBLE
        }
        if(beer.ingredients.malt.size > 2){
            title_malt3.text = beer.ingredients.malt[2].name
            data_malt3.text = beer.ingredients.malt[2].amount.value.toString()+" "+beer.ingredients.malt[2].amount.unit
        }else{
            linear_malt3.visibility = View.INVISIBLE
        }
        if(beer.ingredients.malt.size > 3){
            title_malt4.text = beer.ingredients.malt[3].name
            data_malt4.text = beer.ingredients.malt[3].amount.value.toString()+" "+beer.ingredients.malt[3].amount.unit
        }else{
            linear_malt4.visibility = View.INVISIBLE
        }
        if(beer.ingredients.malt.size > 4){
            title_malt5.text = beer.ingredients.malt[4].name
            data_malt5.text = beer.ingredients.malt[4].amount.value.toString()+" "+beer.ingredients.malt[4].amount.unit
        }else{
            linear_malt5.visibility = View.INVISIBLE
        }
        if(beer.ingredients.malt.size > 5){
            title_malt6.text = beer.ingredients.malt[5].name
            data_malt6.text = beer.ingredients.malt[5].amount.value.toString()+" "+beer.ingredients.malt[5].amount.unit
        }else{
            linear_malt6.visibility = View.INVISIBLE
        }
        if(beer.ingredients.malt.size > 6){
            title_malt7.text = beer.ingredients.malt[6].name
            data_malt7.text = beer.ingredients.malt[6].amount.value.toString()+" "+beer.ingredients.malt[6].amount.unit
        }else{
            linear_malt7.visibility = View.INVISIBLE
        }
    }

    private fun initHops(beer: BeerModel.Beer, v: View) {
        //Hops LinearLayout
        val linear_hops1 = v.findViewById<LinearLayout>(R.id.linear_hops1)
        val linear_hops2 = v.findViewById<LinearLayout>(R.id.linear_hops2)
        val linear_hops3 = v.findViewById<LinearLayout>(R.id.linear_hops3)
        val linear_hops4 = v.findViewById<LinearLayout>(R.id.linear_hops4)
        val linear_hops5 = v.findViewById<LinearLayout>(R.id.linear_hops5)
        val linear_hops6 = v.findViewById<LinearLayout>(R.id.linear_hops6)
        val linear_hops7 = v.findViewById<LinearLayout>(R.id.linear_hops7)
        val linear_hops8 = v.findViewById<LinearLayout>(R.id.linear_hops8)
        val linear_hops9 = v.findViewById<LinearLayout>(R.id.linear_hops9)
        val linear_hops10 = v.findViewById<LinearLayout>(R.id.linear_hops10)

        //Hops List
        val title_hops1 = v.findViewById<TextView>(R.id.hops1_title)
        val title_hops2 = v.findViewById<TextView>(R.id.hops2_title)
        val title_hops3 = v.findViewById<TextView>(R.id.hops3_title)
        val title_hops4 = v.findViewById<TextView>(R.id.hops4_title)
        val title_hops5 = v.findViewById<TextView>(R.id.hops5_title)
        val title_hops6 = v.findViewById<TextView>(R.id.hops6_title)
        val title_hops7 = v.findViewById<TextView>(R.id.hops7_title)
        val title_hops8 = v.findViewById<TextView>(R.id.hops8_title)
        val title_hops9 = v.findViewById<TextView>(R.id.hops9_title)
        val title_hops10 = v.findViewById<TextView>(R.id.hops10_title)

        val data_hops1 = v.findViewById<TextView>(R.id.hops1_data)
        val data_hops2 = v.findViewById<TextView>(R.id.hops2_data)
        val data_hops3 = v.findViewById<TextView>(R.id.hops3_data)
        val data_hops4 = v.findViewById<TextView>(R.id.hops4_data)
        val data_hops5 = v.findViewById<TextView>(R.id.hops5_data)
        val data_hops6 = v.findViewById<TextView>(R.id.hops6_data)
        val data_hops7 = v.findViewById<TextView>(R.id.hops7_data)
        val data_hops8 = v.findViewById<TextView>(R.id.hops8_data)
        val data_hops9 = v.findViewById<TextView>(R.id.hops9_data)
        val data_hops10 = v.findViewById<TextView>(R.id.hops10_data)

        if(beer.ingredients.hops.size > 0){
            title_hops1.text = beer.ingredients.hops[0].name+
                    " ("+beer.ingredients.hops[0].add+" "+beer.ingredients.hops[0].attribute+") "
            data_hops1.text = beer.ingredients.hops[0].amount.value.toString()+" "+beer.ingredients.hops[0].amount.unit
        }else{
            linear_hops1.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 1){
            title_hops2.text = beer.ingredients.hops[1].name+
                    " ("+beer.ingredients.hops[1].add+" "+beer.ingredients.hops[1].attribute+") "
            data_hops2.text = beer.ingredients.hops[1].amount.value.toString()+" "+beer.ingredients.hops[1].amount.unit
        }else{
            linear_hops2.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 2){
            title_hops3.text = beer.ingredients.hops[2].name+
                    " ("+beer.ingredients.hops[2].add+" "+beer.ingredients.hops[2].attribute+") "
            data_hops3.text = beer.ingredients.hops[2].amount.value.toString()+" "+beer.ingredients.hops[2].amount.unit
        }else{
            linear_hops3.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 3){
            title_hops4.text = beer.ingredients.hops[3].name+
                    " ("+beer.ingredients.hops[3].add+" "+beer.ingredients.hops[3].attribute+") "
            data_hops4.text = beer.ingredients.hops[3].amount.value.toString()+" "+beer.ingredients.hops[3].amount.unit
        }else{
            linear_hops4.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 4){
            title_hops5.text = beer.ingredients.hops[4].name+
                    " ("+beer.ingredients.hops[4].add+" "+beer.ingredients.hops[4].attribute+") "
            data_hops5.text = beer.ingredients.hops[4].amount.value.toString()+" "+beer.ingredients.hops[4].amount.unit
        }else{
            linear_hops5.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 5){
            title_hops6.text = beer.ingredients.hops[5].name+
                    " ("+beer.ingredients.hops[5].add+" "+beer.ingredients.hops[5].attribute+") "
            data_hops6.text = beer.ingredients.hops[5].amount.value.toString()+" "+beer.ingredients.hops[5].amount.unit
        }else{
            linear_hops6.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 6){
            title_hops7.text = beer.ingredients.hops[6].name+
                    " ("+beer.ingredients.hops[6].add+" "+beer.ingredients.hops[6].attribute+") "
            data_hops7.text = beer.ingredients.hops[6].amount.value.toString()+" "+beer.ingredients.hops[6].amount.unit
        }else{
            linear_hops7.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 7){
            title_hops8.text = beer.ingredients.hops[7].name+
                    " ("+beer.ingredients.hops[7].add+" "+beer.ingredients.hops[7].attribute+") "
            data_hops8.text = beer.ingredients.hops[7].amount.value.toString()+" "+beer.ingredients.hops[7].amount.unit
        }else{
            linear_hops8.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 8){
            title_hops9.text = beer.ingredients.hops[8].name+
                    " ("+beer.ingredients.hops[8].add+" "+beer.ingredients.hops[8].attribute+") "
            data_hops9.text = beer.ingredients.hops[8].amount.value.toString()+" "+beer.ingredients.hops[8].amount.unit
        }else{
            linear_hops9.visibility = View.INVISIBLE
        }
        if(beer.ingredients.hops.size > 9){
            title_hops10.text = beer.ingredients.hops[9].name+
                    " ("+beer.ingredients.hops[9].add+" "+beer.ingredients.hops[9].attribute+") "
            data_hops10.text = beer.ingredients.hops[9].amount.value.toString()+" "+beer.ingredients.hops[9].amount.unit
        }else {
            linear_hops10.visibility = View.INVISIBLE
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


}