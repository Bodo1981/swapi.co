package com.christianbahl.swapico.base.loadmore

import rx.functions.Func1

/**
 * @author Christian Bahl
 */
class AddLoadMore<M: ILoadMoreResult> : Func1<M, M> {

  override fun call(t: M): M {
    if (t.loadMore) {
      t.addLoadMoreRow()
    }

    return t
  }

}