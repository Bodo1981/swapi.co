package com.christianbahl.swapico.starships

import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.base.loadmore.AddLoadMore
import com.christianbahl.swapico.model.Result
import com.christianbahl.swapico.starships.model.IStarshipsResponseData
import com.christianbahl.swapico.starships.model.StarshipsResponse
import com.github.salomonbrys.kodein.Kodein

/**
 * @author Christian Bahl
 */
class StarshipsPresenter(kodein: Kodein) : BaseLceRxPresenter<StarshipsView, List<IStarshipsResponseData>>(kodein) {

  public fun loadStarships(pullToRefresh: Boolean) {
    subscribe(swapiApi.starships().map(AddLoadMore<Result<StarshipsResponse>>()).doOnNext { view?.setLoadMoreUrl(it.next) }.map { it.results },
        pullToRefresh)
  }

  public fun loadMoreStarships(url: String?, pullToRefresh: Boolean) {
    if (url != null) {
      subscribe(swapiApi.loadMoreStarships(url).map(AddLoadMore<Result<StarshipsResponse>>()).doOnNext {
        view?.setLoadMoreUrl(it.next)
      }.map { it.results },
          pullToRefresh)
    }
  }
}