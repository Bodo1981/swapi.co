package com.christianbahl.swapico.api

import com.christianbahl.swapico.films.model.FilmResponse
import com.christianbahl.swapico.model.Result
import com.christianbahl.swapico.people.model.PeopleResponse
import com.christianbahl.swapico.planets.model.PlanetsResponse
import com.christianbahl.swapico.species.model.SpeciesResponse
import com.christianbahl.swapico.starships.model.StarshipsResponse
import com.christianbahl.swapico.vehicles.model.VehiclesResponse
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

/**
 * @author Christian Bahl
 */
interface SwapiApi {

  // films
  @GET("films/") fun films(@Query("page") page: Int? = null): Observable<Result<FilmResponse>>
  @GET("films/{id}/") fun film(@Path("id") filmdId: Int): Observable<FilmResponse>

  // people
  @GET("people/") fun people(@Query("page") page: Int? = null): Observable<Result<PeopleResponse>>
  @GET("people/{id}/") fun people(@Path("id") peopleId: Int): Observable<PeopleResponse>

  // planets
  @GET("planets/") fun planets(@Query("page") page: Int? = null): Observable<Result<PlanetsResponse>>
  @GET("planets/{id}/") fun planet(@Path("id") planetId: Int): Observable<PlanetsResponse>

  // species
  @GET("species/") fun species(@Query("page") page: Int? = null): Observable<Result<SpeciesResponse>>
  @GET("species/{id}/") fun specie(@Path("id") speciesId: Int): Observable<SpeciesResponse>

  // starships
  @GET("starships/") fun starships(@Query("page") page: Int? = null): Observable<Result<StarshipsResponse>>
  @GET("starships/{id}/") fun starship(@Path("id") starshipId: Int): Observable<StarshipsResponse>

  // vehicles
  @GET("vehicles/") fun vehicles(@Query("page") page: Int? = null): Observable<Result<VehiclesResponse>>
  @GET("vehicles/{id}/") fun vehicle(@Path("id") vehicleId: Int): Observable<VehiclesResponse>

}