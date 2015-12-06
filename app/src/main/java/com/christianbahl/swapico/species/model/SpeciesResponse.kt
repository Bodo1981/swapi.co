package com.christianbahl.swapico.species.model

import com.christianbahl.swapico.model.IListData
import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
class SpeciesResponse(override val name: String,
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
                      override val url: String,
                      val created: String,
                      val edited: String) : IListData