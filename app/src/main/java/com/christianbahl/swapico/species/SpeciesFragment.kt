package com.christianbahl.swapico.species

import android.os.Bundle
import com.christianbahl.swapico.base.loadmore.BaseFragmentLoadMore
import com.christianbahl.swapico.species.model.ISpeciesResponseData
import com.github.salomonbrys.kodein.android.appKodein
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class SpeciesFragment : BaseFragmentLoadMore<ISpeciesResponseData, SpeciesView, SpeciesPresenter, SpeciesAdapter>(), SpeciesView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun createViewState(): LceViewState<MutableList<ISpeciesResponseData>, SpeciesView>? = RetainingLceViewState()

  override fun createPresenter(): SpeciesPresenter? = SpeciesPresenter(appKodein())

  override fun createAdapter(): SpeciesAdapter? = SpeciesAdapter(activity)

  override fun loadData(pullToRefresh: Boolean) = presenter.loadPlanets(pullToRefresh)

  override fun loadMore(loadMoreUrl: String?) = presenter.loadMorePlanets(loadMoreUrl, true)
}