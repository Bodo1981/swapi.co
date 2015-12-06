package com.christianbahl.swapico.starships

import android.os.Bundle
import com.christianbahl.swapico.base.loadmore.BaseFragmentLoadMore
import com.christianbahl.swapico.starships.model.IStarshipsResponseData
import com.github.salomonbrys.kodein.android.appKodein
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class StarshipsFragment : BaseFragmentLoadMore<IStarshipsResponseData, StarshipsView, StarshipsPresenter, StarshipsAdapter>(), StarshipsView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun createViewState(): LceViewState<MutableList<IStarshipsResponseData>, StarshipsView>? = RetainingLceViewState()

  override fun createPresenter(): StarshipsPresenter? = StarshipsPresenter(appKodein())

  override fun createAdapter(): StarshipsAdapter? = StarshipsAdapter(activity)

  override fun loadData(pullToRefresh: Boolean) = presenter.loadStarships(pullToRefresh)

  override fun loadMore(loadMoreUrl: String?) = presenter.loadMoreStarships(loadMoreUrl, true)
}