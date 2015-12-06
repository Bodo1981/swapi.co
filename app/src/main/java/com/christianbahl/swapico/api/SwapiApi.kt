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
import retrofit.http.Url
import rx.Observable

/**
 * @author Christian Bahl
 */
interface SwapiApi {

  @GET("films/") fun films(@Query("page") page: Int): Observable<Result<FilmResponse>>
  @GET("people/") fun people(@Query("page") page: Int): Observable<Result<PeopleResponse>>
  @GET("planets/") fun planets(@Query("page") page: Int): Observable<Result<PlanetsResponse>>
  @GET("species/") fun species(@Query("page") page: Int): Observable<Result<SpeciesResponse>>
  @GET("starships/") fun starships(@Query("page") page: Int): Observable<Result<StarshipsResponse>>
  @GET("vehicles/") fun vehicles(@Query("page") page: Int): Observable<Result<VehiclesResponse>>

  // films
  @GET("films/?format=json") fun films(): Observable<Result<FilmResponse>>
  @GET fun loadMoreFilms(@Url url: String): Observable<Result<FilmResponse>>

  // people
  @GET("people/?format=json") fun people(): Observable<Result<PeopleResponse>>
  @GET fun loadMorePeople(@Url url: String): Observable<Result<PeopleResponse>>

  // planet
  @GET("planets/?format=json") fun planets(): Observable<Result<PlanetsResponse>>
  @GET fun loadMorePlanets(@Url url: String): Observable<Result<PlanetsResponse>>

  // species
  @GET("species/?format=json") fun species(): Observable<Result<SpeciesResponse>>
  @GET fun loadMoreSpecies(@Url url: String): Observable<Result<SpeciesResponse>>

  // starships
  @GET("starships/?format=json") fun starships(): Observable<Result<StarshipsResponse>>
  @GET fun loadMoreStarships(@Url url: String): Observable<Result<StarshipsResponse>>

  // vehicles
  @GET("vehicles/?format=json") fun vehicles(): Observable<Result<VehiclesResponse>>
  @GET fun loadMoreVehicles(@Url url: String): Observable<Result<VehiclesResponse>>
}