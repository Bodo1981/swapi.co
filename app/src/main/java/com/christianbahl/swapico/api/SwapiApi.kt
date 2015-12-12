package com.christianbahl.swapico.api

import com.christianbahl.swapico.films.model.FilmResponse
import com.christianbahl.swapico.model.Result
import com.christianbahl.swapico.people.model.PeopleResponse
import com.christianbahl.swapico.planets.model.PlanetsResponse
import com.christianbahl.swapico.species.model.SpeciesResponse
import com.christianbahl.swapico.starships.model.StarshipsResponse
import com.christianbahl.swapico.vehicles.model.VehiclesResponse
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * @author Christian Bahl
 */
interface SwapiApi {

  @GET("films/") fun films(@Query("page") page: Int? = null): Observable<Result<FilmResponse>>
  @GET("people/") fun people(@Query("page") page: Int? = null): Observable<Result<PeopleResponse>>
  @GET("planets/") fun planets(@Query("page") page: Int? = null): Observable<Result<PlanetsResponse>>
  @GET("species/") fun species(@Query("page") page: Int? = null): Observable<Result<SpeciesResponse>>
  @GET("starships/") fun starships(@Query("page") page: Int? = null): Observable<Result<StarshipsResponse>>
  @GET("vehicles/") fun vehicles(@Query("page") page: Int? = null): Observable<Result<VehiclesResponse>>

}