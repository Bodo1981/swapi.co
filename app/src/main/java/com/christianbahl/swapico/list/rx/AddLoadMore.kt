package com.christianbahl.swapico.list.rx

import com.christianbahl.swapico.list.model.ILoadMoreList
import rx.functions.Func1

/**
 * @author Christian Bahl
 */
class AddLoadMore<M: ILoadMoreList> : Func1<M, M> {

  override fun call(t: M): M {
    if (t.loadMore) {
      t.addLoadMoreRow()
    }

    return t
  }

}