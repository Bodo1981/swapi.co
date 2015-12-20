package com.christianbahl.swapico.films.model

import com.christianbahl.swapico.model.IListData
import com.google.gson.annotations.SerializedName

/**
 * @author Christian Bahl
 */
class FilmResponse(val title: String,
                   val episodeId: Int,
                   @SerializedName("opening_crawl") val openingCrawl: String,
                   val director: String,
                   val producer: String,
                   @SerializedName("release_date") val releaseDate: String,
                   val species: List<String>,
                   val starships: List<String>,
                   val vehicles: List<String>,
                   val characters: List<String>,
                   val planets: List<String>,
                   override val url: String,
                   val created: String,
                   val edited: String) : IListData {

  override val name: String
    get() = title

  override val displayData: Map<String, String>?
    get() = mapOf("Title" to title, "Episode ID" to episodeId.toString(),
        "Opening Crawl" to openingCrawl, "Director" to director, "Producer" to producer,
        "Release date" to releaseDate)

}