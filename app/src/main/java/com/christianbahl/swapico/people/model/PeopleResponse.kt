package com.christianbahl.swapico.people.model

/**
 * @author Christian Bahl
 */
data class PeopleResult(val count: Int,
                        val next: String,
                        val previous: String,
                        val results: List<PeopleResponse>)

data class PeopleResponse(val name: String,
                          @com.google.gson.annotations.SerializedName(
                              "birth_year") val birthYear: String,
                          @com.google.gson.annotations.SerializedName(
                              "eye_color") val eyeColor: String,
                          val gender: String,
                          @com.google.gson.annotations.SerializedName(
                              "hair_color") val hair_Color: String,
                          val height: String,
                          val mass: String,
                          @com.google.gson.annotations.SerializedName(
                              "skin_color") val skinColor: String,
                          val homeworld: String,
                          val films: List<String>,
                          val species: List<String>,
                          val starships: List<String>,
                          val vehicles: List<String>,
                          val url: String,
                          val created: String,
                          val edited: String)