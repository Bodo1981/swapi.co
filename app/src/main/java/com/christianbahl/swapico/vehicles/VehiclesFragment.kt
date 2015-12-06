package com.christianbahl.swapico.vehicles

import android.os.Bundle
import com.christianbahl.swapico.base.loadmore.BaseFragmentLoadMore
import com.christianbahl.swapico.vehicles.model.IVehiclesResponseData
import com.github.salomonbrys.kodein.android.appKodein
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class VehiclesFragment : BaseFragmentLoadMore<IVehiclesResponseData, VehiclesView, VehiclesPresenter, VehiclesAdapter>(), VehiclesView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun createViewState(): LceViewState<MutableList<IVehiclesResponseData>, VehiclesView>? = RetainingLceViewState()

  override fun createPresenter(): VehiclesPresenter? = VehiclesPresenter(appKodein())

  override fun createAdapter(): VehiclesAdapter? = VehiclesAdapter(activity)

  override fun loadData(pullToRefresh: Boolean) = presenter.loadVehicles(pullToRefresh)

  override fun loadMore(loadMoreUrl: String?) = presenter.loadMoreVehicles(loadMoreUrl, true)
}