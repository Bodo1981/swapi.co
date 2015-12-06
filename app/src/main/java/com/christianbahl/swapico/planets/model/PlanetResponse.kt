package com.christianbahl.swapico.planets.model

import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
interface IPlanetResponseData

data class PlanetResponse(val name: String,
                          val diameter: String,
                          @SerializedName("rotation_period") val rotationPeriod: String,
                          val gender: String,
                          @SerializedName("orbital_period") val orbitalPeriod: String,
                          val gravity: String,
                          val population: String,
                          val climate: String,
                          val terrain: String,
                          @SerializedName("surface_water") val surfaceWater: String,
                          val residents: List<String>,
                          val films: List<String>,
                          val url: String,
                          val created: String,
                          val edited: String) : IPlanetResponseData