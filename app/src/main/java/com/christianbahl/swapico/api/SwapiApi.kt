package com.christianbahl.swapico.api

import com.christianbahl.swapico.films.model.FilmResult
import com.christianbahl.swapico.people.model.PeopleResult
import retrofit.http.GET
import retrofit.http.Url
import rx.Observable

/**
 * @author Christian Bahl
 */
interface SwapiApi {

  // films
  @GET("films/?format=json") fun films(): Observable<FilmResult>

  // people
  @GET("people/?format=json") fun people(): Observable<PeopleResult>
  @GET fun loadMorePeople(@Url url: String): Observable<PeopleResult>
}