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

  @GET fun <M: Any?> url(@Url url: String): Observable<M>

  @GET("films/?format=json") fun films(): Observable<FilmResult>
  @GET("people/?format=json") fun people(): Observable<PeopleResult>
}