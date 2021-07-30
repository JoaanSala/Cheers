package com.example.beerproject.Model

import java.io.Serializable

class BeerModel: Serializable{

    data class Beer(
        val id: Int,
        val name: String,
        val tagline: String,
        val first_brewed: String,
        val description: String,
        val image_url: String,
        val abv: Double,
        val ibu: Double,
        val target_fg: Double,
        val target_og: Double,
        val ebc: Double,
        val srm: Double,
        val ph: Double,
        val attenuation_level: Double,

        val volume: Volume,
        val boil_volume: Boil_volume,
        val method: Method,
        val ingredients: Ingredients,

        val food_pairing: List<String>,
        val brewers_tips: String,
        val contributed_by: String
    ):Serializable

    //Volume Data
    data class Volume(
        val value: Int,
        val unit: String
    ):Serializable
    //Boil_Volume Data
    data class Boil_volume (
        val value: Int,
        val unit: String
    ):Serializable
    //Method Data
    data class Method (
        var mash_temp: List<Mash_temp>,
        val fermentation: Fermentation
    ):Serializable
    data class Mash_temp(
        val temp: TempMash,
        val duration: Int
    ):Serializable
    data class TempMash(
        val value: Int,
        val unit: String
    ):Serializable
    data class Fermentation(
        val temp: TempFerm,
        val twist: String
    ):Serializable
    data class TempFerm(
        val value: Double,
        val unit: String
    ):Serializable

    //Ingredients Data
    data class Ingredients(
        val malt: List<Malt>,
        val hops: List<Hops>,
        val yeast: String
    ):Serializable
    data class Malt(
        val name: String,
        val amount: Amount,
    ):Serializable
    data class Amount(
        val value: Double,
        val unit: String
    ):Serializable
    data class Hops(
        val name: String,
        val amount: Amount,
        val add: String,
        val attribute: String
    ):Serializable



}