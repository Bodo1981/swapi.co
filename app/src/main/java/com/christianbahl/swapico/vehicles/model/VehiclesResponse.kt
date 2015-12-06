package com.christianbahl.swapico.vehicles.model

import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
interface IVehiclesResponseData

data class VehiclesResponse(val name: String,
                            val model: String,
                            @SerializedName("vehicle_class") val vehicleClass: String,
                            val manufacturer: String,
                            val length: String,
                            @SerializedName("cost_in_credits") val cost_in_credits: String,
                            val crew: String,
                            val passengers: String,
                            @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
                            @SerializedName("cargo_capacity") val cargoCapacity: String,
                            val consumables: String,
                            val films: List<String>,
                            val pilots: List<String>,
                            val url: String,
                            val created: String,
                            val edited: String) : IVehiclesResponseData