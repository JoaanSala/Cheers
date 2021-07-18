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



        val maltNames = arguments?.getStringArrayList("malt_names")!!
        val maltValues = arguments?.getStringArrayList("malt_values")!!
        val hopsNames = arguments?.getStringArrayList("hops_names")!!
        val hopsValues = arguments?.getStringArrayList("hops_values")!!

        initMalt(maltNames, maltValues, v)
        initHops(hopsNames, hopsValues, v)

        btn_close.setOnClickListener(View.OnClickListener {
            dismiss()
        })

        return builder.create()
    }

    private fun initMalt(maltNames: ArrayList<String>, maltValues: ArrayList<String>, v: View) {
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

        if(maltNames.size >= 1){
            title_malt1.text = maltNames[0]
            data_malt1.text = maltValues[0]
        }else{
            linear_malt1.visibility = View.INVISIBLE
        }
        if(maltNames.size >= 2){
            title_malt2.text = maltNames[1]
            data_malt2.text = maltValues[1]
        }else{
            linear_malt2.visibility = View.INVISIBLE
        }
        if(maltNames.size >= 3){
            title_malt3.text = maltNames[2]
            data_malt3.text = maltValues[2]
        }else{
            linear_malt3.visibility = View.INVISIBLE
        }
        if(maltNames.size >= 4){
            title_malt4.text = maltNames[3]
            data_malt4.text = maltValues[3]
        }else{
            linear_malt4.visibility = View.INVISIBLE
        }
        if(maltNames.size >= 5){
            title_malt5.text = maltNames[4]
            data_malt5.text = maltValues[4]
        }else{
            linear_malt5.visibility = View.INVISIBLE
        }
        if(maltNames.size >= 6){
            title_malt6.text = maltNames[5]
            data_malt6.text = maltValues[5]
        }else{
            linear_malt6.visibility = View.INVISIBLE
        }
        if(maltNames.size >= 7){
            title_malt7.text = maltNames[6]
            data_malt7.text = maltValues[6]
        }else{
            linear_malt7.visibility = View.INVISIBLE
        }
    }

    private fun initHops(hopsNames: ArrayList<String>, hopsValues: ArrayList<String>, v: View) {
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

        if(hopsNames.size >= 1){
            title_hops1.text = hopsNames[0]
            data_hops1.text = hopsValues[0]
        }else{
            linear_hops1.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 2){
            title_hops2.text = hopsNames[1]
            data_hops2.text = hopsValues[1]
        }else{
            linear_hops2.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 3){
            title_hops3.text = hopsNames[2]
            data_hops3.text = hopsValues[2]
        }else{
            linear_hops3.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 4){
            title_hops4.text = hopsNames[3]
            data_hops4.text = hopsValues[3]
        }else{
            linear_hops4.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 5){
            title_hops5.text = hopsNames[4]
            data_hops5.text = hopsValues[4]
        }else{
            linear_hops5.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 6){
            title_hops6.text = hopsNames[5]
            data_hops6.text = hopsValues[5]
        }else{
            linear_hops6.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 7){
            title_hops7.text = hopsNames[6]
            data_hops7.text = hopsValues[6]
        }else{
            linear_hops7.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 8){
            title_hops8.text = hopsNames[7]
            data_hops8.text = hopsValues[7]
        }else{
            linear_hops8.visibility = View.INVISIBLE
        }
        if(hopsNames.size >= 9){
            title_hops9.text = hopsNames[8]
            data_hops9.text = hopsValues[8]
        }else{
            linear_hops9.visibility = View.INVISIBLE
        }
        if(hopsNames.size == 10){
            title_hops10.text = hopsNames[9]
            data_hops10.text = hopsValues[9]
        }else{
            linear_hops10.visibility = View.INVISIBLE
        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


}