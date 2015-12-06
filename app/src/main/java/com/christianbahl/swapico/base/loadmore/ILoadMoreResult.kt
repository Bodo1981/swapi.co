package com.christianbahl.swapico.base.loadmore

/**
 * @author Christian Bahl
 */
interface ILoadMoreResult {

  val loadMore: Boolean
  val adapterList: MutableList<Any>?

  fun addLoadMoreRow() {
    adapterList?.add(LoadMoreRow())
  }

}