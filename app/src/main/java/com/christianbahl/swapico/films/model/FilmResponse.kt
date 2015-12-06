package com.christianbahl.swapico.films.model

import com.christianbahl.swapico.base.loadmore.ILoadMoreResult

/**
 * @author Christian Bahl
 */
interface IFilmResponseData

data class FilmResult(val count: Int,
                      val next: String?,
                      val previous: String,
                      val results: List<FilmResponse>) : ILoadMoreResult {

  override val loadMore: Boolean
    get() = next?.isNotBlank() ?: false

  override val adapterList: MutableList<Any>?
    get() = results as MutableList<Any>

}

data class FilmResponse(val title: String,
                        val episodeId: Int,
                        @com.google.gson.annotations.SerializedName(
                            "opening_crawl") val openingCrawl: String,
                        val director: String,
                        val producer: String,
                        @com.google.gson.annotations.SerializedName(
                            "release_date") val releaseDate: String,
                        val species: List<String>,
                        val starships: List<String>,
                        val vehicles: List<String>,
                        val characters: List<String>,
                        val planets: List<String>,
                        val url: String,
                        val created: String,
                        val edited: String) : IFilmResponseData