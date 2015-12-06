package com.christianbahl.swapico.people.model

import com.christianbahl.swapico.base.loadmore.ILoadMoreResult

/**
 * @author Christian Bahl
 */
interface IPeopleResponseData

data class PeopleResult(val count: Int,
                        val next: String?,
                        val previous: String?,
                        val results: MutableList<PeopleResponse>) : ILoadMoreResult {

  override val loadMore: Boolean
    get() = next?.isNotBlank() ?: false

  override val adapterList: MutableList<Any>?
    get() = results as MutableList<Any>

}

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
                          val edited: String) : IPeopleResponseData