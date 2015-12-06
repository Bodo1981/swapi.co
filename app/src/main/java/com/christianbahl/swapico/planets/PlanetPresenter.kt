package com.christianbahl.swapico.planets

import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.base.loadmore.AddLoadMore
import com.christianbahl.swapico.planets.model.IPlanetResponseData
import com.christianbahl.swapico.planets.model.PlanetResult
import com.github.salomonbrys.kodein.Kodein

/**
 * @author Christian Bahl
 */
class PlanetPresenter(kodein: Kodein) : BaseLceRxPresenter<PlanetView, List<IPlanetResponseData>>(kodein) {

  public fun loadPlanets(pullToRefresh: Boolean) {
    subscribe(swapiApi.planets().map(AddLoadMore<PlanetResult>()).doOnNext { view?.setLoadMoreUrl(it.next) }.map { it.results },
        pullToRefresh)
  }

  public fun loadMorePlanets(url: String?, pullToRefresh: Boolean) {
    if (url != null) {
      subscribe(swapiApi.loadMorePlanets(url).map(AddLoadMore<PlanetResult>()).doOnNext {
        view?.setLoadMoreUrl(it.next)
      }.map { it.results },
          pullToRefresh)
    }
  }

}