package com.christianbahl.swapico.vehicles

import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.base.loadmore.AddLoadMore
import com.christianbahl.swapico.model.Result
import com.christianbahl.swapico.vehicles.model.IVehiclesResponseData
import com.christianbahl.swapico.vehicles.model.VehiclesResponse
import com.github.salomonbrys.kodein.Kodein

/**
 * @author Christian Bahl
 */
class VehiclesPresenter(kodein: Kodein) : BaseLceRxPresenter<VehiclesView, List<IVehiclesResponseData>>(kodein) {

  public fun loadVehicles(pullToRefresh: Boolean) {
    subscribe(swapiApi.vehicles().map(AddLoadMore<Result<VehiclesResponse>>()).doOnNext { view?.setLoadMoreUrl(it.next) }.map { it.results },
        pullToRefresh)
  }

  public fun loadMoreVehicles(url: String?, pullToRefresh: Boolean) {
    if (url != null) {
      subscribe(swapiApi.loadMoreVehicles(url).map(AddLoadMore<Result<VehiclesResponse>>()).doOnNext {
        view?.setLoadMoreUrl(it.next)
      }.map { it.results },
          pullToRefresh)
    }
  }
}