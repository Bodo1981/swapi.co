package com.christianbahl.swapico.starships.model

import com.christianbahl.swapico.model.IListData
import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
class StarshipsResponse(override val name: String,
                        val model: String,
                        @SerializedName("starship_class") val starshipClass: String,
                        val manufacturer: String,
                        @SerializedName("cost_in_credits") val costInCredits: String,
                        val length: String,
                        val crew: String,
                        val passengers: String,
                        @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
                        @SerializedName("hyperdrive_rating") val hyperdriveRating: String,
                        @SerializedName("MGLT") val mglt: String,
                        @SerializedName("cargo_capacity") val cargoCapacity: String,
                        val consumables: String,
                        val films: List<String>,
                        val pilots: List<String>,
                        override val url: String,
                        val created: String,
                        val edited: String) : IListData