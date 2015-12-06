package com.christianbahl.swapico.planets

import android.os.Bundle
import com.christianbahl.swapico.base.loadmore.BaseFragmentLoadMore
import com.christianbahl.swapico.planets.model.IPlanetResponseData
import com.github.salomonbrys.kodein.android.appKodein
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class PlanetFragment : BaseFragmentLoadMore<IPlanetResponseData, PlanetView, PlanetPresenter, PlanetAdapter>(), PlanetView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun createViewState(): LceViewState<MutableList<IPlanetResponseData>, PlanetView>? = RetainingLceViewState()

  override fun createPresenter(): PlanetPresenter? = PlanetPresenter(appKodein())

  override fun createAdapter(): PlanetAdapter? = PlanetAdapter(activity)

  override fun loadData(pullToRefresh: Boolean) = presenter.loadPlanets(pullToRefresh)

  override fun loadMore(loadMoreUrl: String?) = presenter.loadMorePlanets(loadMoreUrl, true)
}