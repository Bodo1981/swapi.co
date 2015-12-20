package com.christianbahl.swapico.details

import com.christianbahl.swapico.api.SwapiApi
import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.list.model.ListType
import com.christianbahl.swapico.model.IListData
import javax.inject.Inject

/**
 * @author Christian Bahl
 */
class DetailsPresenter @Inject constructor(swapiApi: SwapiApi) : BaseLceRxPresenter<DetailsView, IListData>(swapiApi) {

  public fun loadData(detailsId: Int, listType: ListType, contentPresent: Boolean) {
    when (listType) {
      ListType.FILMS -> subscribe(swapiApi.film(detailsId).map { it }, contentPresent)
      ListType.PEOPLE -> subscribe(swapiApi.people(detailsId).map { it }, contentPresent)
      ListType.PLANETS -> subscribe(swapiApi.planet(detailsId).map { it }, contentPresent)
      ListType.SPECIES -> subscribe(swapiApi.specie(detailsId).map { it }, contentPresent)
      ListType.STARSHIPS -> subscribe(swapiApi.starship(detailsId).map { it }, contentPresent)
      ListType.VEHICLES -> subscribe(swapiApi.vehicle(detailsId).map { it }, contentPresent)
    }
  }
}