package com.christianbahl.swapico.api

import com.christianbahl.swapico.films.model.FilmResult
import com.christianbahl.swapico.people.model.PeopleResult
import com.christianbahl.swapico.planets.model.PlanetResult
import com.christianbahl.swapico.species.model.SpeciesResult
import retrofit.http.GET
import retrofit.http.Url
import rx.Observable

/**
 * @author Christian Bahl
 */
interface SwapiApi {

  // films
  @GET("films/?format=json") fun films(): Observable<FilmResult>
  @GET fun loadMoreFilms(@Url url: String): Observable<FilmResult>

  // people
  @GET("people/?format=json") fun people(): Observable<PeopleResult>
  @GET fun loadMorePeople(@Url url: String): Observable<PeopleResult>

  // planet
  @GET("planets/?format=json") fun planets(): Observable<PlanetResult>
  @GET fun loadMorePlanets(@Url url: String): Observable<PlanetResult>

  // planet
  @GET("species/?format=json") fun species(): Observable<SpeciesResult>
  @GET fun loadMoreSpecies(@Url url: String): Observable<SpeciesResult>
}