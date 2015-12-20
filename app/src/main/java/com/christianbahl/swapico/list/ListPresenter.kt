package com.christianbahl.swapico.list

import com.christianbahl.swapico.api.SwapiApi
import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.list.model.ListItem
import com.christianbahl.swapico.list.model.ListModel
import com.christianbahl.swapico.list.model.ListType
import com.christianbahl.swapico.list.rx.AddLoadMore
import com.christianbahl.swapico.list.rx.ResultToListModelFunc
import com.christianbahl.swapico.model.IListData
import com.christianbahl.swapico.model.Result
import rx.Observable
import javax.inject.Inject

/**
 * @author Christian Bahl
 */
class ListPresenter @Inject constructor(swapiApi: SwapiApi, val type: ListType) : BaseLceRxPresenter<ListView, List<ListItem>>(swapiApi) {

  public fun loadData(page: Int, pullToRefresh: Boolean) {
    when (type) {
      ListType.FILMS ->
        subscribe(transformData(swapiApi.films(page = page)), pullToRefresh)
      ListType.PEOPLE ->
        subscribe(transformData(swapiApi.people(page = page)), pullToRefresh)
      ListType.PLANETS ->
        subscribe(transformData(swapiApi.planets(page = page)), pullToRefresh)
      ListType.SPECIES ->
        subscribe(transformData(swapiApi.species(page = page)), pullToRefresh)
      ListType.STARSHIPS ->
        subscribe(transformData(swapiApi.starships(page = page)), pullToRefresh)
      ListType.VEHICLES ->
        subscribe(transformData(swapiApi.vehicles(page = page)), pullToRefresh)
    }
  }

  private fun <M : IListData> transformData(observable: Observable<Result<M>>) =
      observable.doOnNext {
        if (isViewAttached) {
          view.setHasNextPage(it.next?.isNotBlank() ?: false)
        }
      }.map(ResultToListModelFunc<Result<M>, M>()).map(AddLoadMore<ListModel>()).map { it.listData }
}