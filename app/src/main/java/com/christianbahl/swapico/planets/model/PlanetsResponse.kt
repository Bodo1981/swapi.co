package com.christianbahl.swapico.planets.model

import com.christianbahl.swapico.model.IListData
import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
class PlanetsResponse(override val name: String,
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
                      override val url: String,
                      val created: String,
                      val edited: String) : IListData {

  override val displayData: Map<String, String>?
    get() = mapOf("Title" to name, "Diameter" to diameter, "Rotation period" to rotationPeriod,
        "Gender" to gender, "Orbital period" to orbitalPeriod, "Gravity" to gravity,
        "Population" to population, "Climate" to climate, "Terrain" to terrain,
        "Surface water" to surfaceWater)
}