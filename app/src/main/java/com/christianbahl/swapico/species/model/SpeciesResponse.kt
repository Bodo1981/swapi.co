package com.christianbahl.swapico.species.model

import com.christianbahl.swapico.base.loadmore.ILoadMoreResult
import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
interface ISpeciesResponseData

data class SpeciesResult(val count: Int,
                         val next: String?,
                         val previous: String?,
                         val results: MutableList<SpeciesResponse>) : ILoadMoreResult {

  override val loadMore: Boolean
    get() = next?.isNotBlank() ?: false

  override val adapterList: MutableList<Any>?
    get() = results as MutableList<Any>

}

data class SpeciesResponse(val name: String,
                           val classification: String,
                           val designation: String,
                           @SerializedName("average_height") val averageHeight: String,
                           @SerializedName("average_lifespan") val averageLifespan: String,
                           @SerializedName("eye_colors") val eyeColors: String,
                           @SerializedName("hair_colors") val hairColors: String,
                           @SerializedName("skin_colors") val skinColors: String,
                           val language: String,
                           val homeworld: String,
                           val people: List<String>,
                           val films: List<String>,
                           val url: String,
                           val created: String,
                           val edited: String) : ISpeciesResponseData