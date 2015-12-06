package com.christianbahl.swapico.base.loadmore

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * @author Christian Bahl
 */
class LoadMoreScrollListener(val layoutManager: LinearLayoutManager, val onLoadMore: () -> Unit) : RecyclerView.OnScrollListener() {

  companion object {
    private val ITEMS_BEFORE_LAST_ITEM = 3
    private val TAG = LoadMoreScrollListener::class.java.canonicalName
  }

  public var isLoading: Boolean = false

  override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
    super.onScrolled(recyclerView, dx, dy)

    val lastVisibleItem = layoutManager.findLastVisibleItemPosition() + 1 // +1 because position starts at 0
    val totalItemCount = layoutManager.itemCount

    if (!isLoading && totalItemCount <= (lastVisibleItem + ITEMS_BEFORE_LAST_ITEM)) {
      onLoadMore()
    }
  }
}