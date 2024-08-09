package com.example.aymanyasin_comp304lab4_ex1

data class LandmarkType(val name: String,
                        val imageRes: Int){

    var landmarks: List<Landmark> = listOf()

}

data class Landmark(

    val name: String,
    val imageRes: Int,

    )
