package com.christianbahl.swapico.people

import android.os.Bundle
import com.christianbahl.swapico.base.loadmore.BaseFragmentLoadMore
import com.christianbahl.swapico.people.model.IPeopleResponseData
import com.github.salomonbrys.kodein.android.appKodein
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class PeopleFragment : BaseFragmentLoadMore<IPeopleResponseData, PeopleView, PeoplePresenter, PeopleAdapter>(), PeopleView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun createPresenter(): PeoplePresenter? = PeoplePresenter(appKodein())

  override fun createAdapter(): PeopleAdapter? = PeopleAdapter(activity)

  override fun createViewState(): LceViewState<MutableList<IPeopleResponseData>, PeopleView>? = RetainingLceViewState()

  override fun loadData(pullToRefresh: Boolean) = presenter.loadPeople(pullToRefresh)

  override fun loadMore(loadMoreUrl: String?) = presenter.loadMorePeople(loadMoreUrl, true)

}