package com.christianbahl.swapico.people.model

import com.christianbahl.swapico.model.IListData
import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
class PeopleResponse(override val name: String,
                     @SerializedName("birth_year") val birthYear: String,
                     @SerializedName("eye_color") val eyeColor: String,
                     val gender: String,
                     @SerializedName("hair_color") val hair_Color: String,
                     val height: String,
                     val mass: String,
                     @SerializedName("skin_color") val skinColor: String,
                     val homeworld: String,
                     val films: List<String>,
                     val species: List<String>,
                     val starships: List<String>,
                     val vehicles: List<String>,
                     override val url: String,
                     val created: String,
                     val edited: String) : IListData