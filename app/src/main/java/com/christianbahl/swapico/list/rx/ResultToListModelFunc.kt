package com.christianbahl.swapico.list.rx

import com.christianbahl.swapico.list.model.ListItem
import com.christianbahl.swapico.list.model.ListModel
import com.christianbahl.swapico.model.IListData
import com.christianbahl.swapico.model.Result
import rx.functions.Func1

/**
 * @author Christian Bahl
 */
class ResultToListModelFunc<R : Result<M>, M : IListData> : Func1<R, ListModel> {

  override fun call(result: R) =
      ListModel(result.results.map { ListItem(it.name, it.url) }, result.next)

}