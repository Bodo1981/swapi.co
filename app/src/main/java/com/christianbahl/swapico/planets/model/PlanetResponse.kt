package com.christianbahl.swapico.planets.model

import com.christianbahl.swapico.base.loadmore.ILoadMoreResult

/**
 * @author Christian Bahl
 */
interface IPlanetResponseData

data class PlanetResult(val count: Int,
                        val next: String?,
                        val previous: String?,
                        val results: MutableList<PlanetResponse>) : ILoadMoreResult {

  override val loadMore: Boolean
    get() = next?.isNotBlank() ?: false

  override val adapterList: MutableList<Any>?
    get() = results as MutableList<Any>

}

data class PlanetResponse(val name: String,
                          val diameter: String,
                          @com.google.gson.annotations.SerializedName(
                              "rotation_period") val rotationPeriod: String,
                          val gender: String,
                          @com.google.gson.annotations.SerializedName(
                              "orbital_period") val orbitalPeriod: String,
                          val gravity: String,
                          val population: String,
                          val climate: String,
                          val terrain: String,
                          @com.google.gson.annotations.SerializedName(
                              "surface_water") val surfaceWater: String,
                          val residents: List<String>,
                          val films: List<String>,
                          val url: String,
                          val created: String,
                          val edited: String) : IPlanetResponseData