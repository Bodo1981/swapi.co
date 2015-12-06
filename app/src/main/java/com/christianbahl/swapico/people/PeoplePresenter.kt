package com.christianbahl.swapico.people

import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.base.loadmore.AddLoadMore
import com.christianbahl.swapico.model.Result
import com.christianbahl.swapico.people.model.IPeopleResponseData
import com.christianbahl.swapico.people.model.PeopleResponse
import com.github.salomonbrys.kodein.Kodein

/**
 * @author Christian Bahl
 */
class PeoplePresenter(kodein: Kodein) : BaseLceRxPresenter<PeopleView, List<IPeopleResponseData>>(kodein) {

  public fun loadPeople(pullToRefresh: Boolean) {
    subscribe(swapiApi.people().map(AddLoadMore<Result<PeopleResponse>>()).doOnNext { view?.setLoadMoreUrl(it.next) }.map { it.results },
        pullToRefresh)
  }

  public fun loadMorePeople(url: String?, pullToRefresh: Boolean) {
    if (url != null) {
      subscribe(swapiApi.loadMorePeople(url).map(AddLoadMore<Result<PeopleResponse>>()).doOnNext {
        view?.setLoadMoreUrl(it.next)
      }.map { it.results },
          pullToRefresh)
    }
  }
}