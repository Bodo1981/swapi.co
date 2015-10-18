package com.christianbahl.swapico.people

import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.people.model.PeopleResponse
import com.christianbahl.swapico.people.model.PeopleResult

/**
 * @author Christian Bahl
 */
class PeoplePresenter : BaseLceRxPresenter<PeopleView, List<PeopleResponse>>() {

  public fun loadPeople(pullToRefresh: Boolean) {
    subscribe(swapiApi.people().doOnNext { view?.setLoadMoreUrl(it.next) }.map { it.results },
              pullToRefresh)
  }

  public fun loadMorePeople(url: String?, pullToRefresh: Boolean) {
    if (url != null) {
      subscribe(swapiApi.url<PeopleResult>(url).doOnNext {
        view?.setLoadMoreUrl(it.next)
      }.map { it.results },
                pullToRefresh)
    }
  }
}