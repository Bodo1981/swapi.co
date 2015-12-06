package com.christianbahl.swapico.species

import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.base.loadmore.AddLoadMore
import com.christianbahl.swapico.model.Result
import com.christianbahl.swapico.species.model.ISpeciesResponseData
import com.christianbahl.swapico.species.model.SpeciesResponse
import com.github.salomonbrys.kodein.Kodein

/**
 * @author Christian Bahl
 */
class SpeciesPresenter(kodein: Kodein) : BaseLceRxPresenter<SpeciesView, List<ISpeciesResponseData>>(kodein) {

  public fun loadPlanets(pullToRefresh: Boolean) {
    subscribe(swapiApi.species().map(AddLoadMore<Result<SpeciesResponse>>()).doOnNext { view?.setLoadMoreUrl(it.next) }.map { it.results },
        pullToRefresh)
  }

  public fun loadMorePlanets(url: String?, pullToRefresh: Boolean) {
    if (url != null) {
      subscribe(swapiApi.loadMoreSpecies(url).map(AddLoadMore<Result<SpeciesResponse>>()).doOnNext {
        view?.setLoadMoreUrl(it.next)
      }.map { it.results },
          pullToRefresh)
    }
  }

}