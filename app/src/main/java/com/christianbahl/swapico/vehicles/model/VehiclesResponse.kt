package com.christianbahl.swapico.vehicles.model

import com.christianbahl.swapico.model.IListData
import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
class VehiclesResponse(override val name: String,
                       val model: String,
                       @SerializedName("vehicle_class") val vehicleClass: String,
                       val manufacturer: String,
                       val length: String,
                       @SerializedName("cost_in_credits") val costInCredits: String,
                       val crew: String,
                       val passengers: String,
                       @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
                       @SerializedName("cargo_capacity") val cargoCapacity: String,
                       val consumables: String,
                       val films: List<String>,
                       val pilots: List<String>,
                       override val url: String,
                       val created: String,
                       val edited: String) : IListData {

  override val displayData: Map<String, String>?
    get() = mapOf("Title" to name, "Model" to model, "Vehicle class" to vehicleClass,
        "Manufacturer" to manufacturer, "Length" to length, "Cost in credits" to costInCredits,
        "Crew" to crew, "Passengers" to passengers, "Max atmosphering speed" to maxAtmospheringSpeed,
        "Cargo capacity" to cargoCapacity, "Consumables" to consumables)
}